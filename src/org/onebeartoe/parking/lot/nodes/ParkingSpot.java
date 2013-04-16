
package org.onebeartoe.parking.lot.nodes;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.onebeartoe.parking.lot.ParkingSpotImage;

/**
 * @author rmarquez
 */
public class ParkingSpot extends Group
{
    
    public ParkingSpot(int x , int y, ParkingSpotImage image, String text)
    {
	setLayoutX(x);
	setLayoutY(y);
		
	Label label = new Label(text);   
	Font font = Font.font("Verdana", FontWeight.BOLD, 15);
//	Font font = new Font(14);
	label.setFont(font);
	HBox vbox = new HBox(5);
	vbox.getChildren().add(image);
	vbox.getChildren().add(label);
	getChildren().add(vbox);
    }
    
}
