/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.model.places;

import bead.model.people.Adult;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Csaba
 */
public class Shop extends Building {
    public Shop() {
        Staff = new Vector<>();
    }
    public int Balance;
    public int TotalStaff;
    public List<Adult> Staff;
}
