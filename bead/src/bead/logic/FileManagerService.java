/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.logic;

import bead.logic.contracts.*;
import bead.model.places.Street;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Csaba
 */
public class FileManagerService implements IFileManagerService {
    private final IEntityBuilderFactory builderFactory = new EntityBuilderFactory();
    
    @Override
    public Street Beolvas(String fileName) {
        Street street = new Street();
                
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            IEntityBuilder builder;
            String sCurrentLine;
            String[] x;

            while ((sCurrentLine = br.readLine()) != null) {
                sCurrentLine = sCurrentLine.replaceAll("\\s+", " "); // duplikált whitespace
                if ("".equals(sCurrentLine.trim())) { // üres sor
                    continue;
                }
                
                x = sCurrentLine.split(" ");
                builder = builderFactory.GetBuilder(x[0]);
                builder.Build(x, street);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        return street;
                
    }   
}
