
package org.onebeartoe.parking.lot.nodes;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * @author rmarquez
 */
public class MapLegend extends Group
{
    public MapLegend(int x , int y, String heading)
    {
	setLayoutX(x);
	setLayoutY(y);

	int width = 340;
	int height = 95;
	
	Rectangle legendBackground = new Rectangle(width, height);
	legendBackground.setFill(Color.BEIGE);
	legendBackground.setStroke(Color.BLACK);
	
	Label label = new Label(heading);   
	Font font = Font.font("Verdana", FontWeight.BOLD, 13);
	label.setFont(font);
	label.setLayoutX(30);
	
	ObservableList<Node> children = getChildren();
	children.add(legendBackground);
	children.add(label);
    }
    
}
