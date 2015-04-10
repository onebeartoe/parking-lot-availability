
package org.onebeartoe.parking.lot.nodes;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.onebeartoe.mapster.items.MapItem;

/**
 * @author rmarquez
 */
public class MapLegend extends MapItem
{
    public MapLegend(String heading)
    {
	int width = 340;
	int height = 105;
	
	Rectangle legendBackground = new Rectangle(width, height);
	legendBackground.setFill(Color.BEIGE);
	legendBackground.setStroke(Color.BLACK);
	
	ObservableList<Node> children = getChildren();
	children.add(legendBackground);
    }    
}
