
package org.onebeartoe.mapster.factories;

import java.awt.Dimension;
import javafx.scene.paint.Color;
import org.onebeartoe.mapster.items.Area;
import org.onebeartoe.mapster.items.MapItem;
import org.onebeartoe.parking.lot.Classification;

/**
 *
 * @author rmarquez
 */
public class AreaFactory extends MapItemFactory
{

    public AreaFactory() 
    {
	minimumColumnCount = 7;
    }
    
    @Override
    MapItem parseDetails(Classification classification, String[] strings) 
    {
	String s = strings[3].trim();
	Color color = Color.web(s);
	
	String label = strings[4].trim();	
	
	s = strings[5].trim();
	int w = Integer.valueOf(s);
	
	s = strings[6].trim();
	int h = Integer.valueOf(s);
	Dimension size = new Dimension(w,h);
	
	MapItem area = new Area(size, color, label);
	
	return area;
    }
    
}
