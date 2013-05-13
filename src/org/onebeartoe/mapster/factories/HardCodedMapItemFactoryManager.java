
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
	
	factories.put(Classification.PARKING_SPOT, new ParkingSpotFactory() );
	factories.put(Classification.MAP_LEGEND, new MapLegendFactory() );
	factories.put(Classification.MAP_NOTE, new MapNoteFactory() );
    }

    @Override
    public MapItemFactory factoryFor(Classification itemType) 
    {
	MapItemFactory factory = factories.get(itemType);
	
	if(factory == null)
	{
	    throw new UnsupportedOperationException("Not supported yet.");
	}
	
	return factory;
    }
    
}
