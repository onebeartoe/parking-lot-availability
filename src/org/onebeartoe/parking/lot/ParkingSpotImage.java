
package org.onebeartoe.parking.lot;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author rmarquez
 */
public class ParkingSpotImage extends Group
{
    
    public ParkingSpotImage(String hexColor)
    {	
	Color color = Color.web(hexColor);
	Circle c = new Circle(5, color);
			
	getChildren().add(c);
    }
    
}
