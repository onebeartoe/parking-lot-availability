
package org.onebeartoe.parking.lot.nodes;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import org.onebeartoe.parking.lot.ParkingSpotImage;

/**
 * This is used to show no image/icon.
 * @author rmarquez
 */
public class MapNoteImage extends ParkingSpotImage
{

    public MapNoteImage(String text)    
    {
	super(text);

	ObservableList<Node> children = getChildren();
	children.removeAll(children);			
    }    
    
}
