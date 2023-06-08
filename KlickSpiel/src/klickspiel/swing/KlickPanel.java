package klickspiel.swing;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import klickspiel.Spielfeld;
import klickspiel.main.KlickSpiel;
import klickspiel.objekte.FischObjekt;
import klickspiel.objekte.HaiObjekt;
import klickspiel.objekte.Objekt;

public class KlickPanel extends JPanel implements MouseListener, ActionListener {
	private static final long serialVersionUID = 1L;
	private Timer timer = new Timer(800, this);
	final int b;
	final int h;
	private final Spielfeld spielfeld;
	int score = 0;
	int FishCounter = 0;
	private KlickFrame frame;

	public KlickPanel(int breite, int hoehe, final Spielfeld spielfeld) {
		b = breite;
		h = hoehe;
		this.spielfeld = spielfeld;
		timer.start();
		addMouseListener(this);
	}

	@Override
	public void paint(Graphics g) {
		final int boxHeight = getHeight() / h;
		final int boxWidth = getWidth() / b;
		super.paint(g);

		for (int x = 0; x < b; x++) {
			for (int y = 0; y < h; y++) {
				Objekt objekt = spielfeld.get(x, y);
				objekt.paint(g, x, y, boxWidth, boxHeight);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		final int posX = e.getX();
		final int posY = e.getY();
		final int boxHeight = getHeight() / h;
		final int boxWidth = getWidth() / b;

		final int feldX = posX / boxWidth;
		final int feldY = posY / boxHeight;

		if (spielfeld.get(feldX, feldY) instanceof FischObjekt) {
			score--;
		}
		if (spielfeld.get(feldX, feldY) instanceof HaiObjekt) {
			score++;
		}
		frame.setScore(score);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		spielfeld.emptySpielfeld();
		spielfeld.createRandomFische();
		FishCounter++;
		if (FishCounter == 20) {
			gameOver();
		}
		repaint();
	}

	public void gameOver() {
		timer.stop();
		JOptionPane.showMessageDialog(this,
				"Spiel vorbei! Du hast\n" + score + " von " + FishCounter + " Punkten erreicht");
		frame.setVisible(false);
		new KlickSpiel();
	}

	public void setFrame(KlickFrame frame) {
		this.frame = frame;
	}
}
