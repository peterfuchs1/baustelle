package baustelle;

import java.util.ArrayList;
import java.util.List;

public class Fahrzeug {
	private static List<String> kennzeichenListe = new ArrayList<>();
	private String kennzeichen;

	private int gewichtMax;

	private int gewichtAktuell;

	private int platz;

	private Beladungstyp beladungstyp;
	private int anzBaustellen;

	public Fahrzeug(String kennzeichen, int gewichtMax,
					int gewichtAktuell, int platz,
					Beladungstyp beladungstyp					) {
		this.setKennzeichen(kennzeichen);
		this.gewichtMax = gewichtMax;
		this.gewichtAktuell = gewichtAktuell;
		this.platz = platz;
		this.beladungstyp = beladungstyp;
		this.anzBaustellen = 0;
	}
	private void setKennzeichen(String kennzeichen) {
		if(kennzeichen != null && !kennzeichen.isBlank() && !kennzeichenListe.contains(kennzeichen)) {
			this.kennzeichen = kennzeichen;
			kennzeichenListe.add(kennzeichen);
		}
		else {
			throw new IllegalArgumentException("ungueltiges Kennzeichen");
		}
	}
	public int freiesBeladungsgewicht() {
		return gewichtMax - gewichtAktuell;
	}

	public String getFahrzeugDaten(){
		return kennzeichen+
				": "+this.freiesBeladungsgewicht()+ " kg"+
				", "+platz+ " m2 "+
				", "+beladungstyp+"("+beladungstyp.getPlatz()+" %)";
	}

	@Override
	public String toString() {
		return "[ " +getFahrzeugDaten()+
		", "+anzBaustellen+" Baustelle (n)"+" ]";
	}
	public void incrementAnzBaustellen() {
		this.anzBaustellen++;
	}
	public void beladen(int gewicht) {
		if(gewichtAktuell + gewicht > gewichtMax) {
			throw new IllegalArgumentException("Beladung uebersteigt maximales Gewicht");
		}
		this.gewichtAktuell += gewicht;
	}

	public int getPlatz() {
		return platz;
	}

	public String getKennzeichen() {
		return kennzeichen;
	}

	public int getGewichtMax() {
		return gewichtMax;
	}

	public int getGewichtAktuell() {
		return gewichtAktuell;
	}

	public int getAnzBaustellen() {
		return anzBaustellen;
	}

	public Beladungstyp getBeladungstyp() {
		return beladungstyp;
	}
}
