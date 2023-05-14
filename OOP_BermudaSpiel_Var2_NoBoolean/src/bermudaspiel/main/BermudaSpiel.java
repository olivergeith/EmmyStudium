package bermudaspiel.main;

import bermudaspiel.Flotte;
import bermudaspiel.Koordinate;
import bermudaspiel.Schiff;
import bermudaspiel.Spielfeld;
import bermudaspiel.swing.BermudaFrame;
import bermudaspiel.swing.BermudaPanel;

public class BermudaSpiel extends Flotte {
	private static int BREITE = 9;
	private static int HOEHE = 7;
	private static int ANZAHL_SCHIFFE = 4;

	public static void main(String[] args) {
		new BermudaSpiel(ANZAHL_SCHIFFE);
	}

	public BermudaSpiel(int AnzahlSchiffe) {
		super(AnzahlSchiffe, BREITE, HOEHE);
		Spielfeld spielfeld = new Spielfeld(BREITE, HOEHE, this);
		BermudaPanel bermudaPanel = new BermudaPanel(BREITE, HOEHE, spielfeld, this);
		BermudaFrame frame = new BermudaFrame(bermudaPanel);
		bermudaPanel.setFrame(frame);
//		timerLabel.start();
	}

	/*
	 * Ich habe mich entschieden Suche in der Klasse Bermuda Spiel zu
	 * implementieren, weil für mich so die einzelnen Klassen in ihren Aufgaben
	 * besser getrennt sind. Für mich ist es am übersichtlichsten, wenn die Klasse
	 * Flotte nur dafür zuständig ist, das Array mit Schiffen zu belegen und zurück
	 * zu geben, ob sich an einer Position ein Schiff befindet, oder nicht. Die
	 * Bermuda Spiel Klasse hat dann alle Methoden die für den Spielverlauf eine
	 * Rolle spielen, wie z.B die Suche.
	 */
	private int getAnzahlHimmelsrichtungen(Koordinate k) {
		int anzahlSchiffeN = 0;
		int anzahlSchiffeO = 0;
		int anzahlSchiffeS = 0;
		int anzahlSchiffeW = 0;
		int anzahlSchiffeNO = 0;
		int anzahlSchiffeSO = 0;
		int anzahlSchiffeSW = 0;
		int anzahlSchiffeNW = 0;

		for (Schiff s : getSchiffe()) {
			// N & S Richtung
			if (s.getX() == k.getX()) {
				if (s.getY() > k.getY()) {
					anzahlSchiffeN++;
				} else {
					anzahlSchiffeS++;
				}
			}
			// O & W Richtung
			if (s.getY() == k.getY()) {
				if (s.getX() > k.getX()) {
					anzahlSchiffeO++;
				} else {
					anzahlSchiffeW++;
				}
			}
			// Diagonale Himmelsrichtungen
			if (Math.abs(s.getY() - k.getY()) == Math.abs(s.getX() - k.getX())) {
				if (s.getX() > k.getX() && s.getY() > k.getY()) {
					anzahlSchiffeNO++;
				}
				if (s.getX() > k.getX() && s.getY() < k.getY()) {
					anzahlSchiffeSO++;
				}
				if (s.getX() < k.getX() && s.getY() < k.getY()) {
					anzahlSchiffeSW++;
				}
				if (s.getX() < k.getX() && s.getY() > k.getY()) {
					anzahlSchiffeNW++;
				}
			}
		}
		int anzahlRichtungen = 0;
		if (anzahlSchiffeN > 0) {
			anzahlRichtungen++;
		}
		if (anzahlSchiffeO > 0) {
			anzahlRichtungen++;
		}
		if (anzahlSchiffeS > 0) {
			anzahlRichtungen++;
		}
		if (anzahlSchiffeW > 0) {
			anzahlRichtungen++;
		}
		if (anzahlSchiffeNO > 0) {
			anzahlRichtungen++;
		}
		if (anzahlSchiffeSO > 0) {
			anzahlRichtungen++;
		}
		if (anzahlSchiffeSW > 0) {
			anzahlRichtungen++;
		}
		if (anzahlSchiffeNW > 0) {
			anzahlRichtungen++;
		}

		return anzahlRichtungen;
	}

	public char suche(Koordinate k) {
		if (istHierSchiff(k)) {
			return 'X';
		}
		return Character.forDigit(getAnzahlHimmelsrichtungen(k), 10); // wandelt von int zu char um und gibt
																		// anzahlSchiffe zurück
	}

	//
	//
	//
	//
	//
	// Ausprobieren

	@SuppressWarnings("unused")
	private int getAnzahlSichtbareSchiffe(Koordinate k) {
		int anzahlSchiffe = 0;
		for (Schiff s : getSchiffe()) {
			if (s.getX() == k.getX()) {
				anzahlSchiffe++;
			}
			if (s.getY() == k.getY()) {
				anzahlSchiffe++;
			}
			if (Math.abs(s.getY() - k.getY()) == Math.abs(s.getX() - k.getX())) {
				anzahlSchiffe++;
			}
		}
		return anzahlSchiffe;
	}

	@SuppressWarnings("unused")
	private int getAnzahlAngrenzendeSchiffe(Koordinate k) {
		int anzahlSchiffe = 0;
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				if (istHierSchiff(new Koordinate(k.getX() + dx, k.getY() + dy))) {
					anzahlSchiffe++;
				}
			}
		}

		return anzahlSchiffe;
	}

}
