/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bead;

import bead.logic.BeadService;
import bead.logic.FileManagerService;
import bead.logic.contracts.*;
import bead.model.places.Street;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Csaba
 */
public class Bead {

    private static IBeadService bSvc;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        IFileManagerService fmSvc = new FileManagerService();
        Street street = fmSvc.Beolvas(args[0]);
        
        bSvc = new BeadService(street);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            String command = "";
            
            while (command != "kilep") {
                System.out.println("Kérem a következő utasítást");
                command = br.readLine();
                ExecuteCommand(command);
            }
        }
        catch (IOException ioe) {
            System.out.println("Hiba a beolvasás közben");
            System.exit(1);
        }

    }
    
    private static void ExecuteCommand(String command) {
        String[] args = command.split(" ");
        switch (args[0]) {
            case "kilep": System.exit(0);
                break;
            case "kiir": bSvc.Kiir();
                break;
            case "elment": bSvc.Elment(args[1]);
                break;
            case "atmegy": bSvc.Atmegy(args[1], Integer.parseInt(args[2]));
                break;
            case "vasarol": bSvc.Vasarol(args[1], Integer.parseInt(args[2]));
                break;
            case "fizetes": bSvc.Fizetes(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                break;
            default: System.out.println("Ismeretlen parancs: " + args[0]);
                System.out.println("\nLehetséges parancsok:\n\tkilep\n\tkiir\n\telment <fájlnév>\n\tatmegy <név> <összeg>\n\tfizetes <házszám> <összeg>");
                break;
        }
    }
}
