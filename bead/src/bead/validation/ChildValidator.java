/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.validation;

import bead.model.people.Child;

/**
 *
 * @author Csaba
 */
public class ChildValidator {
    public static boolean Validate(Child child) {
        return CheckParents(child);
    }

    private static boolean CheckParents(Child child) {
        if (!child.Father.IsMale || child.Mother.IsMale) {
            System.out.println(child.Name + " gyrek szüleinek neme nem megfelelő");
            return false;
        }
        
        return true;
    }
}
