
package org.onebeartoe.mapster.factories;

import org.onebeartoe.mapster.items.Label;
import org.onebeartoe.mapster.items.MapItem;
import org.onebeartoe.parking.lot.Classification;

/**
 *
 * @author rmarquez
 */
public class LabelFactory extends MapItemFactory
{

    public LabelFactory() 
    {
//	minimumColumnCount = 7;
    }
    
    @Override
    MapItem parseDetails(Classification classification, String[] strings) 
    {
	String text = strings[3].trim();	
	MapItem label = new Label(text);
	
	return label;
    }
    
}
