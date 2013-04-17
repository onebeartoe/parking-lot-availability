
package org.onebeartoe.parking.lot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.onebeartoe.parking.lot.nodes.MapLegend;
import org.onebeartoe.parking.lot.nodes.MapNoteImage;
import org.onebeartoe.parking.lot.nodes.ParkingSpot;
import org.onebeartoe.parking.lot.nodes.PolloSpot;

/**
 * The map image was attained from:
 *	"https://maps.google.com/maps?q=Holy+Cross+High+School,+North+San+Felipe+Avenue,+San+Antonio,+TX&hl=en&ll=29.441064,-98.556982&spn=0.001168,0.00142&sll=29.441709,-98.556182&sspn=0.013211,0.022724&oq=holy+cross+high+san+antonio&hq=Holy+Cross+High+School,&hnear=N+San+Felipe+Ave,+San+Antonio,+Bexar,+Texas&t=h&z=20&layer=t"
 * @author rmarquez
 */
public class ParkingLotAvailability extends Application 
{
    
    private List<ParkingSpot> parkingSpots;   
    
    Node legend;
    
    public ParkingLotAvailability()
    {	
	parkingSpots = new ArrayList();		
	
	String inpath = "parking-spots.text";
	InputStream instream = getClass().getResourceAsStream(inpath);
	BufferedReader br = new BufferedReader(new InputStreamReader(instream));
	String line;  			
	try 
	{
	    line = br.readLine();
	    while (line != null)   
	    {
		if( !line.startsWith("#") && !line.trim().equals("") )
		{
		    // this is a parking spot line, and not a comment line
		    parseLine(line);
		}		
		
		line = br.readLine();
	    }	
	    instream.close(); 			
	} 
	catch (IOException ex) 
	{
	    Logger.getLogger(ParkingLotAvailability.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    private ParkingSpotImage imageFor(Classification classification)
    {
	ParkingSpotImage image = null;
	switch(classification)
	{
	    case AVAILABLE:
	    {
		image = new ParkingSpotImage("00ff00");
		break;
	    }
	    case TAKEN:
	    {
		image = new ParkingSpotImage("A8A8A8");
		break;
	    }
	    case UNAVAILABLE:
	    {
		image = new ParkingSpotImage("000000");
		break;
	    }
	    case POLLO:
	    {
		image = new PolloSpot("AA00CC");
		break;
	    }		
	    case MAP_NOTE:
	    {
		image = new MapNoteImage("AA00CC");
		break;
	    }
	    default:
	    {
		image = new ParkingSpotImage("aa33bb");
	    }
	}
	
	return image;
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
	
    private void parseLine(String line)
    {
	String [] strings = line.split(",");		
	try
	{
	    if(strings.length != 4)
	    {
		throw new Exception("Four arguemnts are needed, no more no less.");
	    }
	    else
	    {
		int x = Integer.valueOf( strings[0].trim() );
		int y = Integer.valueOf( strings[1].trim() );

		String s = strings[2].trim();
		Classification classification = Classification.valueOf(s);
		
		String label = strings[3].trim();
		
		switch(classification)
		{
		    case MAP_LEGEND:
		    {
			legend = new MapLegend(x, y, label);
			
			break;
		    }
		    default:
		    {
			ParkingSpotImage image = imageFor(classification);			

			ParkingSpot ps = new ParkingSpot(x, y, image, label);

			parkingSpots.add(ps);
		    }
		}
	    }
	}
	catch(Exception e)
	{
	    System.err.println("An error occured while trying to parse: " + line);
	    e.printStackTrace();;
	}
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
	InputStream instream = ParkingLotAvailability.class.getResourceAsStream("parking-lot.png");
	Image image = new Image(instream);
	ImageView mapView = new ImageView(image);	
        VBox vBox = new VBox();
        vBox.getChildren().add(mapView);
        
        Group root = new Group();
	ObservableList<Node> rootChildren = root.getChildren();
        rootChildren.add(vBox);        

	if(legend != null)
	{
	    rootChildren.add(legend);
	}	
	
	for(ParkingSpot spot : parkingSpots)
	{
	    rootChildren.add(spot);
	}
	
        Scene scene = new Scene(root);        
        primaryStage.setScene(scene);
	
        primaryStage.setTitle("Holy Cross H. S. Parking Lot");        
        primaryStage.show();
    }
        
}
