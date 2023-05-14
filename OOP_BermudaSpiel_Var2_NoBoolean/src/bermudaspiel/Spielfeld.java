package bermudaspiel;

import bermudaspiel.figuren.Figur;
import bermudaspiel.figuren.LeerFigur;
import bermudaspiel.figuren.MarkierungFigur;
import bermudaspiel.figuren.ZahlFigur;
import bermudaspiel.main.BermudaSpiel;

public class Spielfeld {

	static final LeerFigur LEER = new LeerFigur();
	private int b;
	private int h;
	private BermudaSpiel bermudaSpiel;
	Figur[][] figuren;

	public Spielfeld(int breite, int höhe, BermudaSpiel bermudaSpiel2) {
		b = breite;
		h = höhe;
		this.bermudaSpiel = bermudaSpiel2;
		figuren = new Figur[b][h];

		for (int x = 0; x < figuren.length; x++) {
			for (int y = 0; y < figuren[x].length; y++) {
				figuren[x][y] = LEER;
			}
		}

//		for (int x = 0; x < figuren.length; x++) {
//			for (int y = 0; y < figuren[x].length; y++) {
//				char ergebnis = bermudaSpiel.suche(new Koordinate(x, y));
//				int value = Character.getNumericValue(ergebnis);
//				if (ergebnis == 'X') {
//					set(x, y, bermudaSpiel.getSchiff(new Koordinate(x, y)));
//				} else {
//					set(x, y, new ZahlFigur(value));
//				}
//
//			}
//		}
	}

	public void set(int x, int y, Figur symbol) {
		figuren[x][y] = symbol;
	}

	public Figur get(int x, int y) {
		return figuren[x][y];
	}

	public void aufdecken(int feldX, int feldY) {
		char ergebnis = bermudaSpiel.suche(new Koordinate(feldX, feldY));
		int value = Character.getNumericValue(ergebnis);
		if (ergebnis == 'X') {
			Schiff schiff = bermudaSpiel.getSchiff(new Koordinate(feldX, feldY));
			set(feldX, feldY, schiff);
		} else {
			set(feldX, feldY, new ZahlFigur(value));
		}
	}

	public void markieren(int feldX, int feldY) {
		set(feldX, feldY, new MarkierungFigur());

	}

	public void markiereHimmelsrichtungen(int feldX, int feldY) {
		// vertikal markieren
		for (int y = 0; y < h; y++) {
			replaceLeerFigurMitMarkierungFigur(feldX, y);
		}
		// horizontal markieren
		for (int x = 0; x < b; x++) {
			replaceLeerFigurMitMarkierungFigur(x, feldY);
		}

		// diagonal markieren (S/O)
		int x = feldX + 1;
		int y = feldY + 1;
		while (istImSpielfeld(x, y)) {
			replaceLeerFigurMitMarkierungFigur(x, y);
			x++;
			y++;
		}
		// diagonal markieren (N/O)
		x = feldX + 1;
		y = feldY - 1;
		while (istImSpielfeld(x, y)) {
			replaceLeerFigurMitMarkierungFigur(x, y);
			x++;
			y--;
		}
		// diagonal markieren (N/W)
		x = feldX - 1;
		y = feldY - 1;
		while (istImSpielfeld(x, y)) {
			replaceLeerFigurMitMarkierungFigur(x, y);
			x--;
			y--;
		}
		// diagonal markieren (S/W)
		x = feldX - 1;
		y = feldY + 1;
		while (istImSpielfeld(x, y)) {
			replaceLeerFigurMitMarkierungFigur(x, y);
			x--;
			y++;
		}
	}

	private void replaceLeerFigurMitMarkierungFigur(int x, int y) {
		Figur figur = get(x, y);
		if (figur instanceof LeerFigur) {
			set(x, y, new MarkierungFigur());
		}
	}

	private boolean istImSpielfeld(int x, int y) {
		return x >= 0 && x < b && y >= 0 && y < h;
	}

}
