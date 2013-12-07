/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.model.places;

import bead.model.people.Person;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Csaba
 */
public class Street {
    public Street() {
        this.Buildings = new HashMap<>();
        this.People = new HashMap<>();
    }
    public Map<Integer, Building> Buildings;
    public Map<String, Person> People;
}
