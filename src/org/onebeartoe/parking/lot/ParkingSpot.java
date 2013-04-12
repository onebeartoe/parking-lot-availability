
package org.onebeartoe.parking.lot;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

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
	Font font = new Font(14);
	label.setFont(font);
	HBox vbox = new HBox(5);
	vbox.getChildren().add(image);
	vbox.getChildren().add(label);
	getChildren().add(vbox);
    }
    
}
