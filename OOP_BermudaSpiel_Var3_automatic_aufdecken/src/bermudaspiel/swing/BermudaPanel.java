package bermudaspiel.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bermudaspiel.Spielfeld;
import bermudaspiel.figuren.Figur;
import bermudaspiel.figuren.LeerFigur;
import bermudaspiel.figuren.MarkierungFigur;
import bermudaspiel.figuren.ZahlFigur;
import bermudaspiel.main.BermudaSpiel;

public class BermudaPanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	final int anzahlBoxenX;
	final int anzahlBoxenY;
	private final Spielfeld spielfeld;
	private BermudaFrame frame;

	public BermudaPanel(int breite, int hoehe, Spielfeld spielfeld) {
		anzahlBoxenX = breite;
		anzahlBoxenY = hoehe;
		this.spielfeld = spielfeld;
		addMouseListener(this);
	}

	@Override
	public void paint(Graphics g) {
		final int boxHeight = getHeight() / anzahlBoxenY;
		final int boxWidth = getWidth() / anzahlBoxenX;
		super.paint(g);

		for (int i = 0; i < getWidth(); i = i + boxWidth) {
			g.setColor(Color.black);
			g.drawLine(i, 0, i, getHeight());
		}

		for (int i = 0; i < getHeight(); i = i + boxHeight) {
			g.setColor(Color.black);
			g.drawLine(0, i, getWidth(), i);
		}

		for (int x = 0; x < anzahlBoxenX; x++) {
			for (int y = 0; y < anzahlBoxenY; y++) {
				final Figur figur = spielfeld.get(x, y);
				figur.paint(g, x, y, boxWidth, boxHeight);
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		final int posX = e.getX();
		final int posY = e.getY();
		// Ausrechnen welches Feld geklickt wurde
		final int boxHeight = getHeight() / anzahlBoxenY;
		final int boxWidth = getWidth() / anzahlBoxenX;
		final int feldX = posX / boxWidth;
		final int feldY = posY / boxHeight;
		if (e.getButton() == MouseEvent.BUTTON1) {
			// linke Maustaste
			final int aufdecken = spielfeld.aufdecken(feldX, feldY);
			if (aufdecken >= 0) {
				repaint();
				JOptionPane.showMessageDialog(this, "Gewonnen... " + aufdecken + " Felder waren noch offen");
				// spiel neu starten
				new BermudaSpiel(4);
				frame.setVisible(false);
			}

			final Figur figur = spielfeld.get(feldX, feldY);
			// wenn zahlfigur Nachbarn markieren
			if (figur instanceof ZahlFigur && ((ZahlFigur) figur).getSymbol() == '0') {
				spielfeld.markiereNachbarn(feldX, feldY);
			}
		} else {
			// rechte Maustaste
			final Figur figur = spielfeld.get(feldX, feldY);
			if (figur instanceof LeerFigur) {
				spielfeld.markieren(feldX, feldY);
			} else if (figur instanceof MarkierungFigur) {
				spielfeld.set(feldX, feldY, new LeerFigur());
			}

		}

		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void setFrame(BermudaFrame frame) {
		this.frame = frame;
	}

}
