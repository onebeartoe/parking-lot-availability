
package org.onebeartoe.parking.lot;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.onebeartoe.mapster.factories.HardCodedMapItemFactoryManager;
import org.onebeartoe.mapster.factories.MapItemFactory;
import org.onebeartoe.mapster.factories.MapItemFactoryManager;
import org.onebeartoe.mapster.items.MapItem;

/**
 * The map image was attained from:
 *	"https://maps.google.com/maps?q=Holy+Cross+High+School,+North+San+Felipe+Avenue,+San+Antonio,+TX&hl=en&ll=29.441064,-98.556982&spn=0.001168,0.00142&sll=29.441709,-98.556182&sspn=0.013211,0.022724&oq=holy+cross+high+san+antonio&hq=Holy+Cross+High+School,&hnear=N+San+Felipe+Ave,+San+Antonio,+Bexar,+Texas&t=h&z=20&layer=t"
 * @author rmarquez
 */
public class ParkingLotAvailability extends Application 
{
    
    private Preferences preferences;
    
    private List<MapItem> mapItems;   
    
    private Node legend;
    
    private ImageView mapView;
    
    private MapItemFactoryManager factoryManager;
    
    public ParkingLotAvailability()
    {	
	mapItems = new ArrayList();
	
	Class clazz = getClass();
	preferences = Preferences.userNodeForPackage(clazz);
	
	factoryManager = new HardCodedMapItemFactoryManager();
	
	String defaultPath = "campsites.text";
//	String defaultPath = "parking-spots.text";
	
	String inpath = preferences.get("parking-spots-path", defaultPath);	
	
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
    
    public static void main(String[] args) 
    {
        launch(args);
    }
	
    private void parseLine(String line)
    {
	String [] strings = line.split(",");		
	try
	{
	    String s = strings[0].trim();
	    Classification classification = Classification.valueOf(s);
	    MapItemFactory itemFactory = factoryManager.factoryFor(classification);
	    MapItem item = itemFactory.parse(classification, strings);

	    mapItems.add(item);
	}
	catch(Exception e)
	{
	    System.err.println("An error occured while trying to parse: " + line);
	    e.printStackTrace();
	}
    }
    
    @Override
    public void start(Stage primaryStage)
    {
	String mapPath = "images/football-field-rotated.png";
//	String mapPath = "images/parking-lot.png";
	
	InputStream instream = ParkingLotAvailability.class.getResourceAsStream(mapPath);
	Image image = new Image(instream);
	mapView = new ImageView(image);
	
	Button selectMapButton = new Button("Select Map");
	selectMapButton.setOnMouseClicked( new SelectMapHandler() );
	TextField mapField = new TextField();
	BorderPane mapPane = new BorderPane();
	mapPane.setCenter(mapField);
	mapPane.setRight(selectMapButton);
	
	VBox preferencesBox = new VBox(6);	
	ObservableList<Node> preferencesBoxChildren = preferencesBox.getChildren();
	preferencesBoxChildren.add(mapPane);
		
        VBox vBox = new VBox();	
        vBox.getChildren().add(mapView);	
	vBox.getChildren().add(preferencesBox);	
        
        Group root = new Group();
	ObservableList<Node> rootChildren = root.getChildren();		
        rootChildren.add(vBox);
	
	if(legend != null)
	{
	    rootChildren.add(legend);
	}	
	
	for(MapItem spot : mapItems)
	{
	    rootChildren.add(spot);
	}
	
        Scene scene = new Scene(root);        
        primaryStage.setScene(scene);
	
        primaryStage.setTitle("Holy Cross H. S. Parking Lot");        
        primaryStage.show();
    }
    
    private class SelectMapHandler implements EventHandler<MouseEvent>
    {
	@Override
	public void handle(MouseEvent t)
	{
//		preferences.put
	    
	    // this is for the screen grap of the map with identifiers
	    WritableImage image = mapView.snapshot(new SnapshotParameters(), null);
	    BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
	    File outfile = new File("map.png");

	    try 
	    {
		System.out.println("outptuing to : " + outfile.getAbsolutePath() );
		ImageIO.write(bufferedImage, "png", outfile);
	    } 
	    catch (IOException ex) 
	    {
		Logger.getLogger(ParkingLotAvailability.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
        
}


