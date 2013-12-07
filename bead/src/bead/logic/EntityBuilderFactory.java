/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.logic;

import bead.builders.*;
import bead.logic.contracts.IEntityBuilder;
import bead.logic.contracts.IEntityBuilderFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Csaba
 */
public class EntityBuilderFactory implements IEntityBuilderFactory {

    private final static Map<String, Class<? extends IEntityBuilder>> Types;
    static {
        Types = new HashMap<>();
        Types.clear();
        Types.put("lakohaz", HouseBuilder.class);
        Types.put("uzlet", ShopBuilder.class);
        Types.put("ember", AdultBuilder.class);
        Types.put("gyermek", ChildBuilder.class);
    }
    
    @Override
    public IEntityBuilder GetBuilder(String type) {
        Class c = Types.get(type);
        try {
            return (IEntityBuilder)c.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(EntityBuilderFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EntityBuilderFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
