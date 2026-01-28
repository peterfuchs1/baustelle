# Baustelle
- Polymorphie
- UML-Klassendiagramm
- Parameterprüfung
- Test mittels main()

# Aufgabenstellung

## 1. Für die Verwaltung der Baustellenbelieferung sind folgende Klassen zu realisieren:
Ein **Transportunternehmen**    
-	hat eine *id* (eindeutig, unveränderlich, beginnend bei 100000), 
-	einen *Namen* (nicht leerer String) und    
-	eine *Abstellfläche* (in m2 ganzzahlig).Ein Transportunternehmen besitzt Fahrzeuge. 

Jedes **Fahrzeug** besitzt    
-	ein *Kennzeichen* (nicht leerer, konstanter und eindeutiger String), 
-	ein *maximales Beladungsgewicht* (in kg),   
-	ein *aktuelles Beladungsgewicht* (in kg),   
-	einen *Platzbedarf* (in m2) und 
-	einen bestimmten *Beladungstyp* auf.   

Als **Beladungstyp** kommt ausschließlich 
-	NORMAL (O), SPERRGUT (3), GEFAHRENGUT (10), EXPLOSIV (20) zum Einsatz.    
-	Der Wert in Klammer gibt an um wieviel sich der benötigte Platzbedarf auf einer Baustelle prozentuell erhöht, wenn für das Fahrzeug der Beladungstyp gegeben ist.   

Dem Transportunternehmen können *beliebig viele* Fahrzeuge zugeordnet werden, es muss aber darauf geachtet werden, dass alle Fahrzeuge auf der Abstellfläche Platz haben. Hier muss berücksichtigt werden, dass 5% der Abstellfläche nicht verparkt werden dürfen, damit die Fahrzeuge manövrierfähig bleiben.    
Der Beladungstyp ist hier nicht zu berücksichtigen.   
Ein Fahrzeug kann bei maximal einem Transportunternehmen hinterlegt sein.  
 
Zusätzlich zu normalen Fahrzeugen gibt es noch
**Lastwägen**: Diese weisen zusätzlich 
-	eine *Achszahl* (2-, 3- oder 4-Achser) auf.   
-	Das maximale Beladungsgewicht pro Achse darf bei Lastwägen 2 Tonnen nicht unterschreiten.   
-	Der Parkbedarf muss bei Lastwägen >= 10 m2 betragen.   

**Kräne**: Diese weisen zusätzlich    
-	eine *Höhe* (in Meter) und    
-	ein maximales *Hubgewicht* (in kg) auf.    
-	Das maximale Beladungsgewicht muss bei einem Kran immer 0 aufweisen.    
-	Als Beladungstyp muss hier immer NORMAL gesetzt werden.   

Eine **Baustelle** besitzt 
-	eine *Postleitzahl* (ganzzahlig),   
-	einen *Ort* (nicht leerer String),    
-	eine *Straße* (nicht leerer String),    
-	eine *Hausnummer* (ganzzahlig) und    
-	ein *Platzangebot* (in m2).    
Einer Baustelle können *beliebig viele* Fahrzeuge zugeordnet werden.    
Die genauen zum Einsatz kommenden Regeln entnehmen Sie bitte der Beschreibung aus Aufgabe 3.   
Erstellen Sie für obige Angabe ein UML-Klassendiagramm mit den Konstruktoren der Klassen.
(Getter, Setter und toString ) -Methoden müssen nicht eingezeichnet werden.   
Die zusätzlichen 3 Punkte gibt es für das richtige Einzeichnen der Methoden aus Teil 3.   

---

## 2. Implementieren Sie die Klassen aus Teil 1 in Java.    
Für alle Klassen ist jeweils ein Konstruktor zu erstellen, mit welchem alle nicht automatisch generierten Werte von Instanzvariablen gesetzt werden können.    
Der Versuch, illegale Werte zu setzen, muss dazu führen, dass eine Exception geworfen wird. Achten Sie insbesondere auch auf Konstruktorparameter mit dem Wert null.    
Sie dürfen davon ausgehen, dass Collections, die als Parameter übergeben werden, keine null Werte und keine Einträge mehrfach enthalten, das muss nicht extra überprüft werden.
Schreiben Sie alle Konstruktoren und eventuell benötigte zusätzliche Methoden. Werfen Sie Exceptions, wenn Instanzen mit unpassenden Werten erzeugt werden sollen.
Die Ausgabe der verschiedenen Instanzen mittels *System.out.println( )* soll in den folgenden Formaten erfolgen:   

-	Für den **Beladungstyp** ist der Enumerationswert (klein mit großem Anfangsbuchstaben) und der Prozensatz in Klammer auszugeben, also:   
Normal (0%), Sperrgut (3%), Gefahrengut (10%), Explosiv (20%)   
-	**Fahrzeug**:   
[ Kennzeichen: freies Beladungsgewicht kg, Platzbedarf m2 ,Beladungstyp, Anzbaustellen Baustelle (n)]  also z. B.:   
[KO 744: 810 kg, 7 m2, Sperrgut (3%) , 2 Baustelle (n) ]
Das freie Beladungsgewicht errechnet sich aus dem maximalen Beladungsgewicht abzüglich dem aktuellen Beladungsgewicht.
-	**Lastwagen**: 
[ Kennzeichen : freies Beladungsgewicht kg, Platzbedarf m2, Beladungstyp, Achsanzahl Achsen, Anzbaustellen Baustelle (n)] also z. B.:
[K07441: 1250 kg, 15 m2, Explosiv (20%), 3 Achsen, 1 Baustelle (n) ]
-	**Kran**: 
[ Kennzeichen : Hoehe m, Hubgewicht kg, Platzbedarf m2,  Anzbaustellen Baustelle (n)] also z. B.:
[K07442: 15 m, 15000 kg, 20 m2, 3 Baustelle (n) ]
-	**Baustelle**:   
[ PLZ, Ort, Strasse, Hausnummer, Zugewiesene Fahrzeuge: Anz Fahrzeuge] also z. B.:
[2100, Korneuburg, Laaerstrasse, 13, Zugewiesene Fahrzeuge : 4]

-	**Transportunternehmen**:   
[ Id, Name, verfuegbareAbstellflaeche m2 ] also z. B.:
[100001, Cargo Transport, 3750 m2]

---

## 3. Implementieren Sie die folgenden Methoden 
??? die Fragezeichen sind dabei durch passende Datentypen zu ersetzen (eventuell notwendige getter-Methoden sind ebenfalls zu realisieren):   

*??? addFahrzeug(???)*: Einer Baustelle soll ein Fahrzeug zugewiesen werden. Hierbei sind folgende Regeln zu beachten:   
-	Ein Fahrzeug kann bei maximal 2 Baustellen hinterlegt sein.   
-	Die Baustelle muss ausreichend Platzangebot für die Fahrzeuge aufweisen. Hier ist der Beladungstyp zu berücksichtigen.    
-	Wenn beispielsweise ein Fahrzeug mit Beladungstyp.GEFAHRENGUT zugewiesen werden soll, benötigt das Fahrzeug 10% mehr Platzbedarf.   
-	Wenn ein Lastwagen mit Beladungstyp.SPERRGUT zugewiesen werden soll, muss der Baustelle vorher ein Kran zugewiesen worden sein, der die Ladung mit seinem möglichen Hubgewicht heben kann.   

*??? verfuegbareAbstellflaeche (???)*:    
-	Diese Methode retourniert für ein Transportunternehmen die noch verfügbare Abstellfläche.   
-	Diese errechnet sich durch die gesamte Abstellfläche abzüglich der Fläche zur ManövrierfähigkeitDann muss noch der Platzbedarf aller zugewiesenen Fahrzeuge abgezogen werden.   

*??? beladen (??? x)*: Ein Fahrzeug soll mit x kg beladen werden.    
-	Das ist nur möglich, wenn das maximale Beladungsgewicht dadurch nicht überschritten wird.   

*??? maxBeladungsgewicht (???)*:   
-	Es soll aus allen Fahrzeuge eines Transportunternehmens das höchste maximale Beladungsgewicht innerhalb des Transportunternehmens ermittelt und zurückgegeben werden.   

*??? kannBeladungAbladen (???)*:    
-	Diese Methode retourniert einen boolschen Wert für ein Transportunternehmen.    
-	Es wird true retourniert wenn das Transportunternehmen einen Kran besitzt, der das maxBeladungsgewicht desselben Transportunternehmens als Hubgewicht bewegen kann. Ansonsten soll false retourniert werden.   

*??? addFahrzeug (???)*: Einem Transportunternehmen soll ein Fahrzeug zugewiesen werden.    
-	Bitte beachten Sie die angegebenen Regeln aus Aufgabe 1.   
---
## 4. Testlauf mit main( )
Zeigen Sie das Funktionieren Ihrer Klassen und Methoden anhand eines main( ) -Programms, in dem eventuell geworfene Exceptions abgefangen werden.    
Achten Sie darauf, dass das Programm vollständig durchlaufen werden kann und dass dabei möglichst viel der implementierten Funktionalität und auch einige Fehlerfälle demonstriert werden.
Ein möglicher Testplan könnte wie folgt aussehen (die Angabe dient lediglich als Beispiel und ist in nicht ausführbaren pseudo-Code formuliert):   
### Objekterstellungen
**Transportunternehmen:**   
tul („Cargo Transport", 4000 m2)
**Fahrzeuge:**  
fl („K0744", max 1500 kg, 690 kg, 7 m2, SPERRGUT),   
f2 („W123AA", max 800 kg, 0 kg, 5 m2, GEFAHRENGUT)   
**Lastwagen:**   
l1 („K07441", max 3000 kg, 1750 kg, 15 m2, EXPLOSIV, 3 Achsen)   
**Kran:**   
k1 („K07442", Höhe 15 m, Hubgewicht 15000 kg, Platzbedarf 20 m2, max/aktuell 0 kg, NORMAL)   
**Baustellen (sonstige Attribute beliebig wählbar):**  
b1 (60 m2), b2 (10 m2), b3 (80 m2)   
**Methodenaufrufe:**   
tu1.addFahrzeug(f1)   
tu1.addFahrzeug(f2)   
tu1.addFahrzeug(l1)   
tu1.addFahrzeug(k1)   
tu1.verfuegbareAbstellflaeche()   
b1.addFahrzeug(k1)   
b1.addFahrzeug(f1)   
bl .addFahrzeug(l1)   
b1.addFahrzeug(f2) // (Platzbedarf inkl. Beladungstyp)   
b2.addFahrzeug(f1) (2. Baustelle)   
f2.beladen(500) (gültig)   
tu1.maxBeladungsgewicht()   
tu1.kannBeladungAbladen()   
### try/catch-Vorführung (Fehlerfälle):   
**Ungültiger Lastwagen:**   
new Lastwagen(„BADTR1“,1500, O, 12, NORMAL, 2) (max < 2000)   
**Ungültiger Kran:**   
new  Kran(„BADCR1“,10, 5000, 12, 100, 0, NORMAL) (maxBeladungsgewicht <> 0)   
**Regelverletzungen:**   
b3.addFahrzeug(f1) (3. Baustelle),   
f2.beladen(400) (Überladung)   
