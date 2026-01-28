package baustelle;

public class Main {
    public static void main(String[] args) {
        TransportUnternehmen tu1= new TransportUnternehmen("Cargo Transport",4000);
        Fahrzeug f1= new Fahrzeug("KO744",3000,
                    690,7,Beladungstyp.SPERRGUT);
        Fahrzeug f2 = new Fahrzeug("W123AA",800,
                    0,5,Beladungstyp.GEFAHRENGUT);
        Lastwagen l1= new Lastwagen("KO7441",3000,
                    1750,15,Beladungstyp.EXPLOSIV,3);
        Kran k1= new Kran("KO7442",0,
                    20,Beladungstyp.NORMAL,15,15000);
        Baustelle b1= new Baustelle(1200, "Wien", "Baustellenstrasse", 1, 60);
        Baustelle b2= new Baustelle(1300, "Wien", "AndereStrasse", 2, 10);
        Baustelle b3= new Baustelle(1400, "Wien", "DritteStrasse", 3, 80);
        System.out.println("Baustelle 1: " + b1);
        System.out.println("Transportunternehmen 1: " + tu1);
        tu1.addFahrzeug(f1);
        tu1.addFahrzeug(f2);
        tu1.addFahrzeug(l1);
        tu1.addFahrzeug(k1);
        System.out.println("Verfuegbare Abstellflaeche: "+tu1.verfuegbareAbstellflaeche());
        System.out.println("Transportunternehmen 1: " + tu1);
        b1.addFahrzeug(k1);
        b1.addFahrzeug(f1);
        b1.addFahrzeug(l1);
        b1.addFahrzeug(f2);
        f2.beladen(500);
        double maxGewicht=tu1.maxBeladungsgewichtAllerFahrzeuge();
        System.out.println("Maximales Beladungsgewicht aller Fahrzeuge: " + maxGewicht);
        System.out.println("Kann Beladung abladen: " + tu1.kannBelagungAbladen());
        System.out.println("Baustelle 1: " +b1);
        try{
        new Lastwagen("BADTR123", 1500, 2000, 20, Beladungstyp.NORMAL, 2);
        } catch(IllegalArgumentException e) {
            System.out.println("Fehler beim Erstellen des Lastwagens: " + e.getMessage());
        }
        try{
            // fehlerhafter Kran
        new Kran("KRAN1", 500, 10, Beladungstyp.NORMAL, 5, 5000);
        } catch(IllegalArgumentException e) {
            System.out.println("Fehler beim Erstellen des Krans: " + e.getMessage());
        }
        try {
            // fehlerhafte Baustelle
            b3.addFahrzeug(f1);
        } catch(IllegalArgumentException e) {
            System.out.println("Fehler beim Hinzufügen des Fahrzeugs zur Baustelle: " + e.getMessage());
        }
        try {
            // Fahrzeug wird überladen
            f2.beladen(400);
        }
        catch(IllegalArgumentException e) {
            System.out.println("Fehler beim Beladen des Fahrzeugs: " + e.getMessage());
        }


    }
}

