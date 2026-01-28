package baustelle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TransportUnternehmen {
	private static int COUNTER = 100000;
	private final int id;

	private String name;

	private int abstellFlaeche;


	private List<Fahrzeug> fahrzeuge;

	public TransportUnternehmen(String name, int abstellFlaeche) {
		this.id = COUNTER++;
		setName(name);
		this.abstellFlaeche = abstellFlaeche;
		this.fahrzeuge = new ArrayList<Fahrzeug>();
	}
	public void setName(String name) {
		if(name != null && !name.isBlank()) {
			this.name = name;
		}
		else  {
			throw new IllegalArgumentException("Illegal name in TransportUnternehmen");
		}
	}
	public double verfuegbareAbstellflaeche() {
		double belegteFlaeche = 0;
		// ermittle die belegte Flaeche
		// mittels stream api

		double bf = fahrzeuge.stream().mapToDouble(f->f.getPlatz()).sum();
		// alternative ohne stream api
		for(Fahrzeug f : fahrzeuge) {
			belegteFlaeche += f.getPlatz();
		}
		// System.out.println("belegteFlaeche: ohne stream: "+belegteFlaeche);
		// System.out.println("belegteFlaeche: mit stream: "+bf);
		// 5% Puffer fuer Bewegungsfreiheit abziehen
		return 0.95*this.abstellFlaeche - belegteFlaeche;
	}
	public int maxBeladungsgewichtAllerFahrzeuge() {
		// ermittle das maximale Beladungsgewicht aller Fahrzeuge
		// mittels stream api
		return fahrzeuge.stream()
				.mapToInt(Fahrzeug::getGewichtMax)
				.max().orElse(0);
		// alternative ohne stream api
		/*
		int maxGewicht = 0;
		for(Fahrzeug f : fahrzeuge) {
			if(f.getGewichtMax() > maxGewicht) {
				maxGewicht = f.getGewichtMax();
			}
		}
		return maxGewicht;
		 */
	}
	public boolean kannBelagungAbladen() {
		// pruefe ob ein Fahrzeug das Gewicht beladen und abladen kann
		// setzt voraus, dass ein Kran im Fuhrpark ist,
		// der das Gewicht heben kann
		int maxBeladungsgewicht = maxBeladungsgewichtAllerFahrzeuge();
		// Löse mit stream api
		return fahrzeuge.stream()
				.filter(f -> f instanceof Kran)
				.map(f -> (Kran) f)
				.anyMatch(k -> k.getHubgewicht() >= maxBeladungsgewicht);
		// Alternative ohne stream api
		/*
		for(Fahrzeug f : fahrzeuge) {
			if(f instanceof Kran) {
				Kran k = (Kran) f;
				if(k.getHubgewicht() >= maxBeladungsgewicht) {
					return true;
				}
			}
		}
		return false;

		 */
	}
	private double verbrauchterPlatz() {
		double belegteFlaeche = 0;
		for(Fahrzeug f : fahrzeuge) {
			belegteFlaeche += (f.getPlatz()*(100.0+f.getBeladungstyp().getPlatz())/100.0);
		}
		// Berechne mit stream api
		double bf = fahrzeuge.stream()
				.mapToDouble(f -> f.getPlatz() * (100.0 + f.getBeladungstyp().getPlatz()) / 100.0)
				.sum();
		// System.out.println("verbrauchterPlatz ohne stream: " + belegteFlaeche);
		// System.out.println("verbrauchterPlatz mit stream: " + bf);
		return belegteFlaeche;
	}
	public void addFahrzeug(Fahrzeug fahrzeug) {
		double belegteFlaeche = verbrauchterPlatz();
		double neuerBelegterPlatz = belegteFlaeche + (fahrzeug.getPlatz()*(100.0+fahrzeug.getBeladungstyp().getPlatz())/100.0);
		if(neuerBelegterPlatz <= 0.95*this.abstellFlaeche) {
			fahrzeuge.add(fahrzeug);
		}
		else {
			throw new IllegalArgumentException("Nicht genug Abstellflaeche im TransportUnternehmen");
		}
	}
	public String getTransportUnternehmenDaten() {
		return ""+id+
				", "+name+
				", "+verfuegbareAbstellflaeche()+" m2";
	}
	@Override
	public String toString() {
		return "[ " + this.getTransportUnternehmenDaten() + " ]";
	}
}
