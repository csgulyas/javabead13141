/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.builders;

import bead.logic.contracts.IEntityBuilder;
import bead.model.people.*;
import bead.model.places.*;

/**
 *
 * @author Csaba
 */
public class ShopBuilder implements IEntityBuilder<Shop> {

    @Override
    public Shop Build(String[] data, Street street) {
        //System.out.println("Building Shop");
        
        Shop s = new Shop();
        s.BuildingNumber = Integer.parseInt(data[1]);
        s.Balance = Integer.parseInt(data[2]);
        s.TotalStaff = Integer.parseInt(data[3]);
        
        for (int i = 4; i < data.length; i++){
            Person p = street.People.get(data[i]);
            if (p != null) {
                p.WorkplaceNumber = s.BuildingNumber;
                
                House h = (House)street.Buildings.get(p.BuildingNumber);
                h.CurrentlyHere -= 1;
                
                s.Staff.add((Adult)p);
            }
        }
        
        street.Buildings.put(s.BuildingNumber, s);
        
        return s;
    }
    
}
