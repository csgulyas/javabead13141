/*
 * Programozási nyelvek JAVA 2013-14/1 beadandó
 * Gulyás Csaba  * 
 */

package bead.logic;

import bead.logic.contracts.IBeadService;
import bead.model.people.*;
import bead.model.places.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Csaba
 */
public class BeadService implements IBeadService {

    private Street street;
    
    public BeadService(Street street) {
        this.street = street;
    }
    
    @Override
    public void Kilep() {
        System.exit(0);
    }

    @Override
    public void Kiir() {
        List<String> composed = this.PrepareOutput();
        for (String s : composed) {
            System.out.println(s);
        }
    }

    @Override
    public void Elment(String fileName) {
        try {
            String path = System.getProperty("user.dir") + "\\" + fileName;
            PrintWriter writer = new PrintWriter(path);
            
            List<String> composed = this.PrepareOutput();
            for (String s : composed) {
                writer.println(s);
            }
            
            writer.close();
            System.out.println("Kiirva: " + path);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BeadService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Atmegy(String name, int buildingNumber) {
        Person p = this.GetPerson(name);
        
        if (p.BuildingNumber == buildingNumber) {
            return; // nem kell átmenni sehova, már ott van
        }
        
        Building newBuilding = this.GetBuilding(buildingNumber);
        
        if (newBuilding instanceof House) {
            House h = (House)newBuilding;
            if (h.CurrentlyHere + 1 > h.GetResidentsCount()) {
                System.out.println(h.BuildingNumber + " számú ház megtelt, " + name + " nem tud átmenni");
                return;
            }
        }
        
        Building oldBuilding = this.GetBuilding(p.BuildingNumber);
        oldBuilding.CurrentlyHere -= 1;
        
        newBuilding.CurrentlyHere += 1;
        p.BuildingNumber = buildingNumber;
    }

    @Override
    public void Vasarol(String name, int amount) {
        Person buyer = this.GetPerson(name);
        
        if (buyer.Wallet < amount) {
            System.out.println(name + " nem tud itt vásárolni, mert nincs elég pénze.");
            return;
        }
        
        Building currentBuilding = this.GetBuilding(buyer.BuildingNumber);
        
        if (!(currentBuilding instanceof Shop)) {
            System.out.println(currentBuilding.BuildingNumber + " számú ház nem bolt, " + name + " nem tud itt vásárolni");
            return;
        }
        
        Shop shop = (Shop)currentBuilding;
        
        Person clerk = ShopHasGivenGenderWorker(shop, buyer.IsMale);
        
        if (clerk == null) {
            System.out.println(currentBuilding.BuildingNumber + " számú boltban nincs megfellő nemű eladó, " + name + " nem tud itt vásárolni");
            return;
        }
        
        if (clerk.BuildingNumber != currentBuilding.BuildingNumber) {
            this.Atmegy(clerk.Name, currentBuilding.BuildingNumber);
        }
        
        if (buyer instanceof Child) {
            Child c = (Child)buyer;
            if (c.Father.BuildingNumber != shop.BuildingNumber && c.Mother.BuildingNumber != shop.BuildingNumber) {
                this.Atmegy(c.Father.Name, shop.BuildingNumber);
            }
        }
        
        buyer.Wallet -= amount;
        shop.Balance += amount;
    }

    @Override
    public void Fizetes(int buildingNumber, int amount) {
        Building b = this.GetBuilding(buildingNumber);
        if (b instanceof House) {
            System.out.println("A(z) " + buildingNumber + " számú épület nem üzlet.");
            return;
        }
        
        Shop s = (Shop)b;
        
        if (s.Balance < amount * s.TotalStaff) {
            System.out.println("A(z) " + buildingNumber + " számú üzlet kasszájában nincs elég pénz, hogy mind a(z) "+s.TotalStaff+" dolgozójának adjon "+amount+" fizetést (összesen "+amount * s.TotalStaff+"), a kasszában csak " + s.Balance + " van");
            return;
        }
        
        for (Person p : s.Staff) {
            p.Wallet += amount;
            
        }
        s.Balance -= amount * s.TotalStaff;
    }
    
    private Person GetPerson(String name) {
        return this.street.People.get(name);
    }
    
    private Building GetBuilding(int buildingNumber) {
        return this.street.Buildings.get(buildingNumber);
    }
    
    private Person ShopHasGivenGenderWorker(Shop shop, boolean male) {
        for (Person p : shop.Staff) {
            if (p.IsMale == male) {
                return p;
            }
        }
        
        return null;
    }
    
    private List<String> PrepareOutput() {
        List<String> out = new ArrayList<>();
        
        out.add("Épületek:");
        for (Building b : street.Buildings.values()) {
            if (b instanceof House) {
                House h = (House)b;
                out.add("Lakóhaz\tszám: " + h.BuildingNumber + ", lakók száma: " + h.GetResidentsCount());
            }
            else {
                Shop s = (Shop)b;
                String staff = "";
                for (Person p : s.Staff) {
                    staff += " " + p.Name;
                }
                out.add("Üzlet\tszám: " + s.BuildingNumber + ", kassza: " + s.Balance + ", dolgozók: " + s.TotalStaff +"db =>" + staff);
            }
        }
        out.add("");
        out.add("Emberek:");
        for (Person p : street.People.values()) {
            String nem = p.IsMale ? "férfi" : "nő\t";
            if (p instanceof Adult) {
                out.add("Felnőtt\t" + p.Name + "\tnem: " + nem + "\téletkor: " + p.Age + ", most itt van: " + p.BuildingNumber + ", pénztárca: " + p.Wallet);
            }
            else {
                Child c = (Child)p;
                out.add("Gyermek\t" + p.Name + "\tnem: " + nem + "\téletkor: " + p.Age + ", most itt van: " + p.BuildingNumber + ", pénztárca: " + p.Wallet + ", apja: " + c.Father.Name + ", anyja: " + c.Mother.Name);
            }
        }       
        
        return out;
    }
}

