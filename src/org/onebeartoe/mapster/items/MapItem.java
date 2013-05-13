
package org.onebeartoe.mapster.items;

import java.awt.Point;
import javafx.scene.Group;

/**
 * @author rmarquez
 */
public class MapItem extends Group
{

    protected Point location;

    public void setLocation(Point location) 
    {
	setLayoutX(location.x);
	setLayoutY(location.y);
	
	this.location = location;
    }

}
