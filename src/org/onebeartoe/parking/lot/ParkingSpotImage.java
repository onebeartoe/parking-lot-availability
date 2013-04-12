
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
	Circle c = new Circle(5, Color.web(hexColor) );
			
	getChildren().add(c);
    }
    
}
