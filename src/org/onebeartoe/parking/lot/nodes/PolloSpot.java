
package org.onebeartoe.parking.lot.nodes;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.onebeartoe.parking.lot.ParkingSpotImage;

/**
 * @author rmarquez
 */
public class PolloSpot extends ParkingSpotImage
{

    public PolloSpot(String text)    
    {
	super(text);

	ObservableList<Node> children = getChildren();
	children.removeAll(children);	

/*	
	Rectangle feet = new Rectangle(2,4);
	feet.setFill(Color.ORANGE);
	feet.setY(4);
*/	
	
	Circle body = new Circle(4.5);
	body.setFill(Color.YELLOW);
	body.setStroke(Color.BLACK);
	body.setStrokeWidth(0.5);

/*	
	Circle head = new Circle(2.5);
	head.setCenterX(4);
	head.setCenterY(-2);
	head.setFill(Color.YELLOW);	
	head.setStroke(Color.BLACK);
	head.setStrokeWidth(0.5);
	
	Rectangle beak = new Rectangle(3,2);
	beak.setFill(Color.ORANGE);
	beak.setX(5);
	beak.setY(-3);
*/		
		
//	children.add(feet);
	children.add(body);	
//	children.add(head);	
//	children.add(beak);
    }    
    
}
