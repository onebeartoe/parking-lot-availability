
package org.onebeartoe.parking.lot.nodes;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.onebeartoe.mapster.items.MapItem;

/**
 * @author rmarquez
 */
public class MapLegend extends MapItem
{
    public MapLegend(String heading)
    {
//	setLayoutX(location.x);
//	setLayoutY(location.y);

	int width = 340;
	int height = 95;
	
	Rectangle legendBackground = new Rectangle(width, height);
	legendBackground.setFill(Color.BEIGE);
	legendBackground.setStroke(Color.BLACK);
	
	Label label = new Label(heading);   
	Font font = Font.font("Verdana", FontWeight.BOLD, 13);
	label.setFont(font);
	label.setLayoutX(55);
	label.setLayoutY(1);
	
	ObservableList<Node> children = getChildren();
	children.add(legendBackground);
	children.add(label);
    }
    
}
