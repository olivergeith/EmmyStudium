package bermudaspiel;

import bermudaspiel.figuren.Figur;
import bermudaspiel.figuren.LeerFigur;
import bermudaspiel.figuren.MarkierungFigur;
import bermudaspiel.figuren.Schiff;
import bermudaspiel.figuren.ZahlFigur;
import bermudaspiel.main.BermudaSpiel;

public class Spielfeld {

	static final LeerFigur LEER = new LeerFigur();
	private final int anzahlBoxesX;
	private final int anzahlBoxesY;
	private final BermudaSpiel bermudaSpiel;
	Figur[][] figuren;

	public Spielfeld(int anzahlBoxesX, int anzahlBoxesY, BermudaSpiel bermudaSpiel2) {
		this.anzahlBoxesX = anzahlBoxesX;
		this.anzahlBoxesY = anzahlBoxesY;
		bermudaSpiel = bermudaSpiel2;
		figuren = new Figur[anzahlBoxesX][anzahlBoxesY];

		// erstmal alles mit leer figuren füllen!
		for (int x = 0; x < figuren.length; x++) {
			for (int y = 0; y < figuren[x].length; y++) {
				figuren[x][y] = LEER;
			}
		}

	}

	public void set(int x, int y, Figur symbol) {
		if (isValidPosition(x, y)) {
			figuren[x][y] = symbol;
		}
	}

	public Figur get(int x, int y) {
		if (isValidPosition(x, y)) {
			return figuren[x][y];
		}
		return null;
	}

	public int aufdecken(int x, int y, boolean automatic) {
		if (isValidPosition(x, y)) {
			final char ergebnis = bermudaSpiel.suche(new Koordinate(x, y));
			final int value = Character.getNumericValue(ergebnis);
			if (ergebnis == 'X') {
				set(x, y, bermudaSpiel.getSchiff(new Koordinate(x, y)));
				java.awt.Toolkit.getDefaultToolkit().beep();
				// check, ob alle Schiffe aufgedeckt wurden?
				if (getAnzahlGefundeneSchiffe() == bermudaSpiel.getAnzahlSchiffe()) {
					// Gewonnen... wir können alles aufdecken
					return allesAufdecken();
				}

			} else {
				set(x, y, new ZahlFigur(value, automatic));
			}
		}
		return -99;
	}

	public int aufdecken(int x, int y) {
		return aufdecken(x, y, false);
	}

	public void markieren(int x, int y) {
		set(x, y, new MarkierungFigur());

	}

	/**
	 * Alles aufdecken, was noch nicht aufgedeckt wurde.
	 *
	 * @return
	 */
	public int getAnzahlGefundeneSchiffe() {
		int count = 0;
		for (int x = 0; x < anzahlBoxesX; x++) {
			for (int y = 0; y < anzahlBoxesY; y++) {
				final Figur figur = get(x, y);
				if (figur instanceof Schiff) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Alles aufdecken, was noch nicht aufgedeckt wurde. Zählt alle Felder, die noch
	 * offen waren. Das ist vielleicht interessant für eine Auswertung zum
	 * schluss... je früher alle Schiffe gefunden wurden (je mehr noch offen war),
	 * desto gut?!
	 */
	public int allesAufdecken() {
		int count = 0;
		for (int x = 0; x < anzahlBoxesX; x++) {
			for (int y = 0; y < anzahlBoxesY; y++) {
				final Figur figur = get(x, y);
				if (figur instanceof LeerFigur) {
					aufdecken(x, y, true);
					count++;
				}
			}
		}
		return count;
	}

	public void markiereNachbarn(int feldX, int feldY) {
		markierenGleicheReihe(feldX, feldY);
		markierenGleicheSpalte(feldX, feldY);
		markierenDiagonalenTopLeftBottemRight(feldX, feldY);
		markierenDiagonalenBottomLeftTopRight(feldX, feldY);
	}

	/**
	 * Einfach die reihe von x=0 bis ende durchgehen und aufdecken, was noch
	 * Leerfigur ist
	 *
	 * @param feldX
	 * @param feldY
	 */
	private void markierenGleicheReihe(int feldX, int feldY) {
		final int y = feldY;
		for (int x = 0; x < anzahlBoxesX; x++) {
			final Figur figur = get(x, feldY);
			if (figur instanceof LeerFigur) {
				aufdecken(x, y, true);
//				set(x, y, new MarkierungFigur());
			}
		}
	}

	private void markierenGleicheSpalte(int feldX, int feldY) {
		final int x = feldX;
		for (int y = 0; y < anzahlBoxesY; y++) {
			final Figur figur = get(x, y);
			if (figur instanceof LeerFigur) {
				aufdecken(x, y, true);
//				set(x, y, new MarkierungFigur());
			}
		}
	}

	private void markierenDiagonalenTopLeftBottemRight(int feldX, int feldY) {
		int x = feldX + 1;
		int y = feldY + 1;

		while (isValidPosition(x, y)) {
			final Figur figur = get(x, y);
			if (figur instanceof LeerFigur) {
				aufdecken(x, y, true);
//				set(x, y, new MarkierungFigur());
			}
			x++;
			y++;
		}
		x = feldX - 1;
		y = feldY - 1;
		while (isValidPosition(x, y)) {
			final Figur figur = get(x, y);
			if (figur instanceof LeerFigur) {
				aufdecken(x, y, true);
//				set(x, y, new MarkierungFigur());
			}
			x--;
			y--;
		}
	}

	private void markierenDiagonalenBottomLeftTopRight(int feldX, int feldY) {
		int x = feldX + 1;
		int y = feldY - 1;

		while (isValidPosition(x, y)) {
			final Figur figur = get(x, y);
			if (figur instanceof LeerFigur) {
				aufdecken(x, y, true);
//				set(x, y, new MarkierungFigur());
			}
			x++;
			y--;
		}
		x = feldX - 1;
		y = feldY + 1;
		while (isValidPosition(x, y)) {
			final Figur figur = get(x, y);
			if (figur instanceof LeerFigur) {
				aufdecken(x, y, true);
//				set(x, y, new MarkierungFigur());
			}
			x--;
			y++;
		}
	}

	private boolean isValidPosition(int x, int y) {
		return x >= 0 && x < anzahlBoxesX && y >= 0 && y < anzahlBoxesY;
	}

}
