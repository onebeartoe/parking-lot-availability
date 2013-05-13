
package org.onebeartoe.mapster.factories;

import org.onebeartoe.parking.lot.Classification;

/**
 * @author rmarquez
 */
public interface MapItemFactoryManager 
{

    MapItemFactory factoryFor(Classification itemType);
    
}
