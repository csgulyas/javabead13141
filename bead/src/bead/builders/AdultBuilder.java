/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.builders;

import bead.logic.contracts.IEntityBuilder;
import bead.model.people.Adult;
import bead.model.places.House;
import bead.model.places.Street;
import bead.validation.PersonValidator;

/**
 *
 * @author Csaba
 */
public class AdultBuilder implements IEntityBuilder<Adult> {

    @Override
    public Adult Build(String[] data, Street street) {
        //System.out.println("Building Adult");
        
        Adult a = new Adult();
        a.Name = data[1];
        a.IsMale = "ferfi".equals(data[2]);
        a.Age = Integer.parseInt(data[3]);
        a.BuildingNumber = Integer.parseInt(data[4]);
        a.Wallet = Integer.parseInt(data[5]);
        
        House h = (House)street.Buildings.get(a.BuildingNumber);
        h.CurrentlyHere += 1;
        
        PersonValidator.Validate(a);
        
        street.People.put(a.Name, a);
        return a;
    }
    
}
