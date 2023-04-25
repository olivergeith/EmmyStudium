package bermudaspiel;

import java.awt.Color;
import java.awt.Graphics;

import bermudaspiel.figuren.Figur;

public class Schiff extends Koordinate implements Figur {

	public Schiff(int wert1, int wert2) {
		super(wert1, wert2);
	}

	boolean schiffSichtbar = false;

	@Override
	public char getSymbol() {
		return 'X';
	}

	public void setAufgedeckt() {
		java.awt.Toolkit.getDefaultToolkit().beep();
		schiffSichtbar = true;

	}

	public boolean istAufgedeckt() {
		return schiffSichtbar;
	}

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.red);
//		g.setColor(Color.WHITE);
		g.fillOval(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);
		g.setColor(Color.BLACK);
		g.drawOval(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);
		g.drawString("" + getSymbol(), xpos * boxBreite + boxBreite / 2, ypos * boxHoehe + boxHoehe / 2);
	}

}
