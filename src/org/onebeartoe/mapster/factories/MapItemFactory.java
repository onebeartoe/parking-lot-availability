
package org.onebeartoe.mapster.factories;

import java.awt.Point;
import org.onebeartoe.mapster.items.MapItem;
import org.onebeartoe.parking.lot.Classification;

/**
 * @author rmarquez
 */
public abstract class MapItemFactory 
{
    /**
     * Set this value in sub-classes.
     */
    protected int minimumColumnCount = 4;    
    
    public MapItem parse(Classification classification, String [] strings) throws Exception
    {
	checkParameterLength(strings);
	
	MapItem item = parseDetails(classification, strings);
	Point location = parseLocation(strings);
	item.setLocation(location);
	
	return item;
    }
     
    public void checkParameterLength(String [] strings) throws Exception 
    {
	if(strings.length != minimumColumnCount)
	{
	    throw new Exception(minimumColumnCount + " arguemnts are needed, no more no less.");
	}
    }
    
//    abstract int getParameterCount();
    
    public Point parseLocation(String [] strings) 
    {
	int x = Integer.valueOf( strings[1].trim() );
        int y = Integer.valueOf( strings[2].trim() );
	
	return new Point(x,y);
    }
    
    abstract MapItem parseDetails(Classification classification, String [] strings);
       
}
