
package org.onebeartoe.parking.lot;

/**
 * @author rmarquez
 */
public enum Classification 
{
    AVAILABLE("available.png"),
    TAKEN("taken.png"),
    UNAVAILABLE("unavailable.png");
            
    public String imagePath;
    
    Classification(String imagePath)
    {
	this.imagePath = imagePath;		
    }
    
}
