/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.builders;

import bead.logic.contracts.IEntityBuilder;
import bead.model.places.*;

/**
 *
 * @author Csaba
 */
public class HouseBuilder implements IEntityBuilder<House> {

    @Override
    public House Build(String[] data, Street street) {
        //System.out.println("Building House");
        
        House h = new House(Integer.parseInt(data[2]));
        h.BuildingNumber = Integer.parseInt(data[1]);
        h.CurrentlyHere = 0;
        
        street.Buildings.put(h.BuildingNumber, h);
        
        return h;
    }
    
}
