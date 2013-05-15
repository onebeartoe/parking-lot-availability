
package org.onebeartoe.mapster.items;

import java.awt.Dimension;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * @author rmarquez
 */
public class Area extends MapItem
{
    public Area(Dimension size, Color color, String text)
    {
	Rectangle area = new Rectangle(size.width, size.height, color);
	area.setArcHeight(9);
	area.setArcWidth(9);
	area.setStroke(Color.NAVY);
	
	Label label = new Label(text);   
	Font font = Font.font("Verdana", FontWeight.BOLD, 15);
	label.setFont(font);
	label.setTextFill(Color.NAVY);
	
	StackPane stack = new StackPane();
	ObservableList<Node> stackChildren = stack.getChildren();
	stackChildren.add(area);
	stackChildren.add(label);
	
	ObservableList<Node> children = getChildren();
	children.add(stack);
    }
}
