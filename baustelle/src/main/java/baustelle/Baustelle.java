package baustelle;

import java.util.ArrayList;
import java.util.List;

public class Baustelle {
    private int plz;
    private String ort;
    private String strasse;
    private int hausnummer;
    private int platzangebot;
    private List<Fahrzeug> fahrzeuge;

    public Baustelle(int plz, String ort, String strasse, int hausnummer, int platzangebot) {
        this.plz = plz;
        this.setOrt(ort);
        this.setStrasse(strasse);
        this.hausnummer = hausnummer;
        this.platzangebot = platzangebot;
        this.fahrzeuge = new ArrayList<Fahrzeug>();
    }
    public void setOrt(String ort) {
        if(ort != null && !ort.isBlank()) {
            this.ort = ort;
        }
        else {
            throw new IllegalArgumentException("Illegal ort in Baustelle");
        }
    }
    public void setStrasse(String strasse) {
        if(strasse != null && !strasse.isBlank()) {
            this.strasse = strasse;
        }
        else {
            throw new IllegalArgumentException("Illegal strasse in Baustelle");
        }
    }
    public void addFahrzeug(Fahrzeug fahrzeug) {
        if(fahrzeug == null ) {
            throw new IllegalArgumentException("Illegal fahrzeug in Baustelle");
        }
        if(fahrzeuge.contains(fahrzeug)) {
            throw new IllegalArgumentException("Fahrzeug ist bereits in der Baustelle vorhanden");
        }
        if(fahrzeug.getAnzBaustellen() == 2) {
            throw new IllegalArgumentException("Fahrzeug ist bereits in 2 Baustellen vorhanden");
        }
        // Summe der belegten Plaetze
        // Achtung Fahrzeug belegt 10% mehr Platz
        // bei Gefahrengut
        double belegterPlatz = 0;
        boolean kranVorhanden = false;
        // pruefen ob Kran in der Baustelle vorhanden ist
        // mittels stream api
        boolean kranExists = fahrzeuge.stream().anyMatch(f -> f instanceof Kran);
        // alternative ohne stream api
        for(Fahrzeug f : fahrzeuge) {
            // Testen ob Kran vorhanden
            if(f instanceof Kran) {
                kranVorhanden = true;
            }
            double platz = f.getPlatz();
            if( f.getBeladungstyp()==Beladungstyp.GEFAHRENGUT) {
                    platz = platz * 1.1;
            }
            belegterPlatz += platz;
        }
        // Berechnen den belegten Platz vor dem Hinzufuegen des neuen Fahrzeugs
        // für alle bereits vorhandenen Fahrzeuge
        // achtung Gefahrengut belegt 10% mehr Platz
        // verwende stream api
        double fahrzeugPlatz = fahrzeuge.stream().mapToDouble(f -> f.getPlatz()).sum();
        double gefahrengutPlatz = fahrzeuge.stream()
                .filter(f -> f.getBeladungstyp() == Beladungstyp.GEFAHRENGUT)
                .mapToDouble(f -> f.getPlatz() * 0.1)
                .sum();
        double belegterPlatzStream = fahrzeugPlatz + gefahrengutPlatz;
        System.out.println("Belegter Platz mit stream: " + belegterPlatzStream);
        System.out.println("Belegter Platz ohne stream: " + belegterPlatz);
        double maxBelegterPlatz = platzangebot;
        if(belegterPlatz + fahrzeug.getPlatz() <= maxBelegterPlatz) {
            // Lastwagen mit Beladungstyp Sperrgut
            // darf erst der Baustelle hinzugefügt werden, wenn
            // bereits Kran in der Baustelle ist
            if(fahrzeug instanceof Lastwagen && fahrzeug.getBeladungstyp() == Beladungstyp.SPERRGUT) {
                if(!kranVorhanden) {
                    throw new IllegalArgumentException("Kein Kran in der Baustelle fuer Lastwagen mit Sperrgut");
                }

            }
            fahrzeuge.add(fahrzeug);
            fahrzeug.incrementAnzBaustellen();
        }
        else {
            throw new IllegalArgumentException("Nicht genug Platz in der Baustelle fuer das Fahrzeug");
        }

    }
    @Override
    public String toString() {
        return "Baustelle{" +
                "plz=" + plz +
                ", ort='" + ort + '\'' +
                ", strasse='" + strasse + '\'' +
                ", hausnummer=" + hausnummer +
                ", platzangebot=" + platzangebot +
                ", fahrzeuge=" + fahrzeuge +
                '}';
    }
}
