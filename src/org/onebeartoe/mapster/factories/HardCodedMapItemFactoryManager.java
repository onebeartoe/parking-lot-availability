
package org.onebeartoe.mapster.factories;

import java.util.HashMap;
import java.util.Map;
import org.onebeartoe.parking.lot.Classification;

/**
 * @author rmarquez
 */
public class HardCodedMapItemFactoryManager implements MapItemFactoryManager
{
    
    Map<Classification, MapItemFactory> factories;
    
    public HardCodedMapItemFactoryManager()
    {
	factories = new HashMap();
	
	factories.put(Classification.AREA, new AreaFactory() );
	factories.put(Classification.LABEL, new LabelFactory() );
	factories.put(Classification.MAP_LEGEND, new MapLegendFactory() );
	factories.put(Classification.MAP_NOTE, new MapNoteFactory() );
	factories.put(Classification.PARKING_SPOT, new ParkingSpotFactory() );
    }

    @Override
    public MapItemFactory factoryFor(Classification itemType) 
    {
	MapItemFactory factory = factories.get(itemType);
	
	if(factory == null)
	{
	    throw new UnsupportedOperationException("No known factory exists for " + itemType + ".");
	}
	
	return factory;
    }
    
}
