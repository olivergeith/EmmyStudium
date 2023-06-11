package bermudaspiel.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bermudaspiel.HighDialog;
import bermudaspiel.Highscore;
import bermudaspiel.Schiff;
import bermudaspiel.Score;
import bermudaspiel.Spielfeld;
import bermudaspiel.figuren.Figur;
import bermudaspiel.figuren.LeerFigur;
import bermudaspiel.figuren.MarkierungFigur;
import bermudaspiel.figuren.ZahlFigur;
import bermudaspiel.main.BermudaSpiel;

public class BermudaPanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	final int b;
	final int h;
	private final Spielfeld spielfeld;
	private BermudaSpiel bermudaSpiel;
	private BermudaFrame frame;
	private Highscore highscore;

	public BermudaPanel(final int breite, final int hoehe, final Spielfeld spielfeld, BermudaSpiel bermudaSpiel) {
		b = breite;
		h = hoehe;
		this.spielfeld = spielfeld;
		this.bermudaSpiel = bermudaSpiel;
		this.addMouseListener(this);
		this.highscore = Highscore.getInstance();
	}

	@Override
	public void paint(final Graphics g) {
		final int boxHeight = getHeight() / h;
		final int boxWidth = getWidth() / b;
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
	public void mouseClicked(final MouseEvent e) {

	}

	@Override
	public void mousePressed(final MouseEvent e) {
		final int posX = e.getX();
		final int posY = e.getY();
		// Ausrechnen welches Feld geklickt wurde
		final int boxHeight = getHeight() / h;
		final int boxWidth = getWidth() / b;

		final int feldX = posX / boxWidth;
		final int feldY = posY / boxHeight;

		// linke Maustaste
		if (e.getButton() == MouseEvent.BUTTON1) {
			spielfeld.aufdecken(feldX, feldY);
			Figur figur = spielfeld.get(feldX, feldY);
			if (figur instanceof ZahlFigur && ((ZahlFigur) figur).getSymbol() == '0') {
				spielfeld.markiereHimmelsrichtungen(feldX, feldY);
			}
			if (figur instanceof Schiff schiff) {
				schiff.setAufgedeckt();
			}

			if (bermudaSpiel.alleSchiffeGefunden()) {
				repaint();
				TimerLabel.getInstance().stop();
				JOptionPane.showMessageDialog(this, "Gewonnen!");

				String name = JOptionPane.showInputDialog(this, "Name");

				highscore.add(new Score(name, TimerLabel.getInstance().stop()));
				highscore.save();
				if (name != null) {
					HighDialog highDialog = new HighDialog(new JPanel(), highscore);
					highDialog.setVisible(true);
					neustart();
				}

			}
			// rechte Maustaste
		} else {
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
	public void mouseReleased(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void setFrame(BermudaFrame frame2) {
		this.frame = frame2;

	}

	public void neustart() {
		new BermudaSpiel(4);
		frame.setVisible(false);
		TimerLabel.getInstance().start();
	}

}
