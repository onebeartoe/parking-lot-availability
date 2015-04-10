
package org.onebeartoe.mapster.factories;

import org.onebeartoe.mapster.items.MapItem;
import org.onebeartoe.mapster.items.ParkingSpotClassification;
import org.onebeartoe.parking.lot.Classification;
import org.onebeartoe.parking.lot.nodes.ParkingSpot;
import org.onebeartoe.parking.lot.nodes.ParkingSpotImage;
import org.onebeartoe.parking.lot.nodes.PolloSpot;

/**
 * @author rmarquez
 */
public class ParkingSpotFactory extends MapItemFactory
{

    public ParkingSpotFactory() 
    {
	minimumColumnCount = 5;
    }    

    private ParkingSpotImage imageFor(ParkingSpotClassification classification)
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
	    default:
	    {
		image = new ParkingSpotImage("aa33bb");
	    }
	}
	
	return image;
    }
    
    @Override
    public MapItem parseDetails(Classification classification, String [] strings) 
    {
	String label = strings[4].trim();
	
	String s = strings[3].trim();
	ParkingSpotClassification spotType = ParkingSpotClassification.valueOf(s);
		
	ParkingSpotImage image = imageFor(spotType);
	
	ParkingSpot spot = new ParkingSpot(image, label);
	
	return spot;
    }
    
}
