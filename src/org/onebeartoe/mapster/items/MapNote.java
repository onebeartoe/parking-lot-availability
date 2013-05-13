
package org.onebeartoe.mapster.items;

import javafx.scene.Node;
import org.onebeartoe.parking.lot.nodes.ParkingSpot;

/**
 * This is used to have a parking spot entry with no image/icon.
 * @author rmarquez
 */
public class MapNote extends ParkingSpot//Image
{

    public MapNote(Node image, String text)    
    {	
	super(image, text);

// wth?	
//	ObservableList<Node> children = getChildren();
//	children.removeAll(children);			
    }    
    
}
