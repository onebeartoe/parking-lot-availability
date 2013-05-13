
package org.onebeartoe.parking.lot.nodes;

import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 * This is used to have a parking spot entry with no image/icon.
 * @author rmarquez
 */
public class MapNoteImage extends ParkingSpot//Image
{

    public MapNoteImage(Node image, String text)    
    {	
	super(image, text);

// wth?	
//	ObservableList<Node> children = getChildren();
//	children.removeAll(children);			
    }    
    
}
