/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.logic.contracts;

/**
 *
 * @author Csaba
 */
public interface IEntityBuilderFactory {
    IEntityBuilder GetBuilder(String type);
}
