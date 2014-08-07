
package org.onebeartoe.mapster.items;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author rmarquez
 */
public class Label extends MapItem
{

    public Label(String text) 
    {
	javafx.scene.control.Label label = new javafx.scene.control.Label(text);   
	Font font = Font.font("Verdana", FontWeight.BOLD, 15);
	label.setFont(font);
	label.setTextFill(Color.NAVY);
	
	StackPane stack = new StackPane();
	ObservableList<Node> stackChildren = stack.getChildren();	
	stackChildren.add(label);
	
	ObservableList<Node> children = getChildren();
	children.add(stack);
    }
    
}
