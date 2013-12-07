/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.validation;

import bead.model.people.Person;

/**
 *
 * @author Csaba
 */
public class PersonValidator {
    public static boolean Validate(Person person) {
        return CheckMoney(person);
    }
    
    private static boolean CheckMoney(Person person) {
        if (person.Wallet < 0) {
            System.out.println(person.Name + " pénze negatív");
            return false;
        }
        
        return true;
    }
}
