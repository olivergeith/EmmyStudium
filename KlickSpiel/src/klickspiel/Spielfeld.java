package klickspiel;

import klickspiel.main.KlickSpiel;
import klickspiel.objekte.FischObjekt;
import klickspiel.objekte.HaiObjekt;
import klickspiel.objekte.Objekt;
import klickspiel.objekte.PlatzhalterObjekt;

public class Spielfeld {
	static final PlatzhalterObjekt LEER = new PlatzhalterObjekt();
	Objekt[][] objekte;
	private KlickSpiel klickspiel;
	private int b;
	private int h;

	public Spielfeld(int breite, int höhe, KlickSpiel klickspiel) {
		b = breite;
		h = höhe;
		this.klickspiel = klickspiel;
		objekte = new Objekt[b][h];
		for (int x = 0; x < objekte.length; x++) {
			for (int y = 0; y < objekte[x].length; y++) {
				objekte[x][y] = LEER;
			}
		}
	}

	public void set(int x, int y, Objekt objekt) {
		objekte[x][y] = objekt;
	}

	public Objekt get(int x, int y) {
		return objekte[x][y];
	}

	public void emptySpielfeld() {
		for (int x = 0; x < objekte.length; x++) {
			for (int y = 0; y < objekte[x].length; y++) {
				objekte[x][y] = LEER;
			}
		}
	}

	public void createRandomFische() {
		java.util.Random zufall = new java.util.Random();
		int fischXpos = zufall.nextInt(b);
		int fischYpos = zufall.nextInt(h);
		set(fischXpos, fischYpos, new FischObjekt());
		// gucken dass nicht an selber Stelle!!!
		int haiXpos = zufall.nextInt(b);
		int haiYpos = zufall.nextInt(h);
		while (haiXpos == fischXpos && haiYpos == fischYpos) {
			haiXpos = zufall.nextInt(b);
			haiYpos = zufall.nextInt(h);
		}
		set(haiXpos, haiYpos, new HaiObjekt());
	}

}
