/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.model.places;

/**
 *
 * @author Csaba
 */
public class House extends Building {
    private int residentsCount;
    
    public House(int res) {
        this.residentsCount = res;
    }
    
    public int GetResidentsCount() {
        return this.residentsCount;
    }
}
