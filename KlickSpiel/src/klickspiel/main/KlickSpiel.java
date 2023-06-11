package klickspiel.main;

import javax.swing.JOptionPane;

import klickspiel.Spielfeld;
import klickspiel.swing.KlickFrame;
import klickspiel.swing.KlickPanel;

public class KlickSpiel {
	private static int BREITE = 12;
	private static int HOEHE = 12;
	private static int ANZAHLRUNDEN = 20;

	public KlickSpiel(int anzahlRunden) {
		Spielfeld spielfeld = new Spielfeld(BREITE, HOEHE, this);
		KlickPanel klickpanel = new KlickPanel(BREITE, HOEHE, spielfeld, ANZAHLRUNDEN);
		JOptionPane.showMessageDialog(klickpanel, "Spiel starten? \nVersuche alle Haie zu töten");
		KlickFrame frame = new KlickFrame(klickpanel);
		klickpanel.setFrame(frame);
		KlickSpiel.ANZAHLRUNDEN = anzahlRunden;
		spielfeld.createRandomFische();
	}

	public static void main(String[] args) {
		new KlickSpiel(ANZAHLRUNDEN);
	}
}
