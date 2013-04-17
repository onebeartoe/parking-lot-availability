
package org.onebeartoe.parking.lot;

/**
 * @author rmarquez
 */
public enum Classification 
{
    AVAILABLE("available.png"),
    TAKEN("taken.png"),
    UNAVAILABLE("unavailable.png"),
    POLLO(""),
    MAP_LEGEND(""),
    MAP_NOTE("");
            
    public String imagePath;
    
    Classification(String imagePath)
    {
	this.imagePath = imagePath;		
    }
    
}
