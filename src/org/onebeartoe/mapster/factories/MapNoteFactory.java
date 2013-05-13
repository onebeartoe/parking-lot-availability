/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.onebeartoe.mapster.factories;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.onebeartoe.mapster.items.MapItem;
import org.onebeartoe.mapster.items.MapNote;
import org.onebeartoe.parking.lot.Classification;


/**
 *
 * @author rmarquez
 */
public class MapNoteFactory extends MapItemFactory
{

    @Override
    MapItem parseDetails(Classification classification, String[] strings) 
    {
	String label = strings[3].trim();
	Node image = new Circle(3, Color.BLACK);
	MapItem legend = new MapNote(image, label);
		
	return legend;
    }
    
}
