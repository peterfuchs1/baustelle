package baustelle;

public enum Beladungstyp {

	NORMAL(0),

	SPERRGUT(3),

	GEFAHRENGUT(10),

	EXPLOSIV(20);

	private Beladungstyp(int value) {
		this.value = value;
	}
	private int value;
	public int getPlatz() {
		return value;
	}




}
