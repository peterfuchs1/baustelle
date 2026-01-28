package baustelle;

public class Lastwagen extends Fahrzeug {

	public int getAchsenzahl() {
		return achsenzahl;
	}

	private int achsenzahl;


	public Lastwagen(String kennzeichen, int gewichtMax, int gewichtAktuell, int platz,
					 Beladungstyp beladungstyp, int achsenzahl) {
		super(kennzeichen, gewichtMax, gewichtAktuell, platz, beladungstyp);
		this.achsenzahl = achsenzahl;
		gewichtMax(gewichtMax);
		platz(platz);

	}
	public void gewichtMax(int gewichtMax) {
		if(gewichtMax<2000) {
			throw new IllegalArgumentException("Das maximale Gewicht ist zu gering");
		}
	}
	public void platz(int platz) {
		if(platz<10) {
			throw new IllegalArgumentException("Platz zu gering fuer Lastwagen");
		}
	}
	public String getLastwagenDaten(){
		return ""+this.achsenzahl+" Achsen"+
				", "+this.getAnzBaustellen();
	}
	@Override
	public String toString() {
		return "[ "+ this.getLastwagenDaten()+" ]";
	}
}
