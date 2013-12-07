/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.builders;

import bead.logic.contracts.IEntityBuilder;
import bead.model.people.*;
import bead.model.places.Street;
import bead.validation.*;

/**
 *
 * @author Csaba
 */
public class ChildBuilder implements IEntityBuilder<Child> {

    @Override
    public Child Build(String[] data, Street street) {
        //System.out.println("Building Child");
        
        Child c = new Child();
        c.Name = data[1];
        c.IsMale = "ferfi".equals(data[2]);
        c.Age = Integer.parseInt(data[3]);
        c.BuildingNumber = Integer.parseInt(data[4]);
        c.Wallet = Integer.parseInt(data[5]);
        
        c.Father = (Adult)street.People.get(data[6]);
        c.Mother = (Adult)street.People.get(data[7]);
        
        PersonValidator.Validate(c);
        ChildValidator.Validate(c);
        
        street.People.put(c.Name, c);
        return c;
    }   
}