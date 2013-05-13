
package org.onebeartoe.parking.lot.nodes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.onebeartoe.mapster.items.MapItem;

/**
 * @author rmarquez
 */
public class ParkingSpotImage extends MapItem
{
    
    public ParkingSpotImage(String hexColor)
    {	
	Color color = Color.web(hexColor);
	Circle c = new Circle(5, color);
			
	getChildren().add(c);
    }
    
}
