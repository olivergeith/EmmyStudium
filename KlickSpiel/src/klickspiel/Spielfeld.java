package klickspiel;

import klickspiel.main.KlickSpiel;
import klickspiel.objekte.FischObjekt;
import klickspiel.objekte.HaiObjekt;
import klickspiel.objekte.Objekt;
import klickspiel.objekte.WasserObjekt;

public class Spielfeld {
	static final WasserObjekt LEER = new WasserObjekt();
	Objekt[][] objekte;
	private int b;
	private int h;
	public int fishCounter;

	public Spielfeld(int breite, int höhe, KlickSpiel klickspiel) {
		b = breite;
		h = höhe;
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

	public void fillSpielfeld() {

		for (int x = 0; x < objekte.length; x++) {
			for (int y = 0; y < objekte[x].length; y++) {
				if (objekte[x][y] instanceof WasserObjekt) {
					objekte[x][y] = LEER;
				}
				if (objekte[x][y] instanceof HaiObjekt) {
					HaiObjekt hai = (HaiObjekt) objekte[x][y];
					hai.lives--;
					if (hai.lives < 1) {
						objekte[x][y] = LEER;
						createRandomFische();
					}
				}
				if (objekte[x][y] instanceof FischObjekt) {
					FischObjekt fisch = (FischObjekt) objekte[x][y];
					fisch.lives--;
					if (fisch.lives < 1) {
						objekte[x][y] = LEER;
					}
				}
			}
		}
	}

	public void createRandomFische() {
		java.util.Random zufall = new java.util.Random();
		fishCounter++;
		int fisch1Xpos = zufall.nextInt(b);
		int fisch1Ypos = zufall.nextInt(h);
		set(fisch1Xpos, fisch1Ypos, new FischObjekt());

		// gucken dass nicht an selber Stelle!!!
		int haiXpos = zufall.nextInt(b);
		int haiYpos = zufall.nextInt(h);
		while (haiXpos == fisch1Xpos && haiYpos == fisch1Ypos) {
			haiXpos = zufall.nextInt(b);
			haiYpos = zufall.nextInt(h);
		}
		set(haiXpos, haiYpos, new HaiObjekt());

		int fisch2Xpos = zufall.nextInt(b);
		int fisch2Ypos = zufall.nextInt(h);
		while ((fisch2Xpos == fisch1Xpos && fisch2Ypos == fisch1Ypos)
				|| (fisch2Xpos == haiXpos && fisch2Ypos == haiYpos)) {
			fisch2Xpos = zufall.nextInt(b);
			fisch2Ypos = zufall.nextInt(h);
		}
		set(fisch2Xpos, fisch2Ypos, new FischObjekt());

	}

}
