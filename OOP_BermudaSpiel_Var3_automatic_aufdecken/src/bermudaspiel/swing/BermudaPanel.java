package bermudaspiel.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import bermudaspiel.Spielfeld;
import bermudaspiel.figuren.Figur;
import bermudaspiel.figuren.LeerFigur;
import bermudaspiel.figuren.MarkierungFigur;
import bermudaspiel.figuren.ZahlFigur;

public class BermudaPanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	final int b;
	final int h;
	private Spielfeld spielfeld;

	public BermudaPanel(int breite, int hoehe, Spielfeld spielfeld) {
		b = breite;
		h = hoehe;
		this.spielfeld = spielfeld;
		addMouseListener(this);
	}

	@Override
	public void paint(Graphics g) {
		int boxHeight = getHeight() / h;
		int boxWidth = getWidth() / b;
		super.paint(g);

		for (int i = 0; i < getWidth(); i = i + boxWidth) {
			g.setColor(Color.black);
			g.drawLine(i, 0, i, getHeight());
		}

		for (int i = 0; i < getHeight(); i = i + boxHeight) {
			g.setColor(Color.black);
			g.drawLine(0, i, getWidth(), i);
		}

		for (int x = 0; x < b; x++) {
			for (int y = 0; y < h; y++) {
				Figur figur = spielfeld.get(x, y);
				figur.paint(g, x, y, boxWidth, boxHeight);
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int posX = e.getX();
		int posY = e.getY();
		// Ausrechnen welches Feld geklickt wurde
		int boxHeight = getHeight() / h;
		int boxWidth = getWidth() / b;
		int feldX = posX / boxWidth;
		int feldY = posY / boxHeight;
		if (e.getButton() == MouseEvent.BUTTON1) {
			// linke Maustaste
			spielfeld.aufdecken(feldX, feldY);
			Figur figur = spielfeld.get(feldX, feldY);
			if (figur instanceof ZahlFigur && ((ZahlFigur) figur).getSymbol() == '0') {
				spielfeld.markierenGleicheReihe(feldX, feldY);
				spielfeld.markierenGleicheSpalte(feldX, feldY);
				spielfeld.markierenDiagonalenTopLeftBottemRight(feldX, feldY);
				spielfeld.markierenDiagonalenBottomLeftTopRight(feldX, feldY);
			}
		} else {
			// rechte Maustaste
			Figur figur = spielfeld.get(feldX, feldY);
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

}
