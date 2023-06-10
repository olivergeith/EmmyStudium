package klickspiel.main;

import javax.swing.JOptionPane;

import klickspiel.Spielfeld;
import klickspiel.swing.KlickFrame;
import klickspiel.swing.KlickPanel;

public class KlickSpiel {
	private static int BREITE = 20;
	private static int HOEHE = 20;
	private static int ANZAHLFISCHE = 20;

	public KlickSpiel(int anzahlFische) {
		Spielfeld spielfeld = new Spielfeld(BREITE, HOEHE, this);
		KlickPanel klickpanel = new KlickPanel(BREITE, HOEHE, spielfeld, ANZAHLFISCHE);
		JOptionPane.showMessageDialog(klickpanel, "Spiel starten? \nVersuche alle Haie zu töten");
		KlickFrame frame = new KlickFrame(klickpanel);
		klickpanel.setFrame(frame);
		KlickSpiel.ANZAHLFISCHE = anzahlFische;
	}

	public static void main(String[] args) {
		new KlickSpiel(ANZAHLFISCHE);
	}
}
