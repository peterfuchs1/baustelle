package baustelle;

public class Kran extends Fahrzeug {

	private int hoehe;

	private int hubgewicht;



	private Beladungstyp beladungsTyp = Beladungstyp.NORMAL;

	public Kran(String kennzeichen, int gewichtAktuell, int platz, Beladungstyp beladungstyp, int hoehe, int hubgewicht) {
		super(kennzeichen, 0, gewichtAktuell, platz, beladungstyp);
		this.hoehe = hoehe;
		this.hubgewicht = hubgewicht;
		gewichtMax(gewichtAktuell);
		beladungsTyp(beladungstyp);
	}
	public void gewichtMax(int gewichtMax) {
		if(gewichtMax!=0) {
			throw new IllegalArgumentException("GewichtMax muss fuer Kran 0 sein");
		}
	}
	public void beladungsTyp(Beladungstyp beladungstyp) {
		if(beladungstyp != Beladungstyp.NORMAL) {
			throw new IllegalArgumentException("Beladungstyp fuer Kran muss NORMAL sein");
		}
	}

	public int getHoehe() {
		return hoehe;
	}

	public int getHubgewicht() {
		return hubgewicht;
	}
	public String getKranDaten(){
		return ": "+this.hoehe+" m"+
				", "+this.hubgewicht+" kg"+
				", "+this.getAnzBaustellen()+" Baustelle (n)";
	}
	@Override
	public String toString() {
		return "[ "+this.getKennzeichen()+": "+this.getKranDaten()+" ]";
	}
}
