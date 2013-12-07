/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.logic.contracts;

/**
 *
 * @author Csaba
 */
public interface IBeadService {
    void Kilep();
    void Kiir();
    void Elment(String fileName);
    void Atmegy(String name, int buildingNumber);
    void Vasarol(String name, int amount);
    void Fizetes(int buildingNumber, int amount);
}
