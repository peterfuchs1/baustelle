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
		if(gewichtMax>2000*achsenzahl) {
			throw new IllegalArgumentException("GewichtMax zu hoch fuer Lastwagen");
		}
	}
	public void platz(int platz) {
		if(platz<10) {
			throw new IllegalArgumentException("Platz zu gering fuer Lastwagen");
		}
	}

	@Override
	public String toString() {
		return super.toString()+" -> Lastwagen{" +
				"achsenzahl=" + achsenzahl +
				'}';
	}
}
