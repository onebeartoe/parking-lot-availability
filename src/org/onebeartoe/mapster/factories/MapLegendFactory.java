
package org.onebeartoe.mapster.factories;

import org.onebeartoe.mapster.items.MapItem;
import org.onebeartoe.parking.lot.Classification;
import org.onebeartoe.parking.lot.nodes.MapLegend;

/**
 *
 * @author rmarquez
 */
public class MapLegendFactory extends MapItemFactory
{    

    @Override
    public MapItem parseDetails(Classification classification, String [] strings) 
    {
	String label = strings[3].trim();
	
	MapItem legend = new MapLegend(label);
		
	return legend;		
    }
    
}
