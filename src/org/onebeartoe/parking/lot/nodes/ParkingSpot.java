
package org.onebeartoe.parking.lot.nodes;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.onebeartoe.mapster.items.MapItem;

/**
 * @author rmarquez
 */
public class ParkingSpot extends MapItem
{
    public ParkingSpot(Node image, String text)  
    {	
	Label label = new Label(text);   
	Font font = Font.font("Verdana", FontWeight.BOLD, 15);
	label.setFont(font);
	HBox vbox = new HBox(5);
	
	if(image != null)
	{
	    vbox.getChildren().add(image);
	}
	
	vbox.getChildren().add(label);
	getChildren().add(vbox);
    }
    
}
