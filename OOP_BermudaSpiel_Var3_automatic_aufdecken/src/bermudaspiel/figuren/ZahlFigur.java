package bermudaspiel.figuren;

import java.awt.Color;
import java.awt.Graphics;

public class ZahlFigur implements Figur {
	int zahl;
	private boolean automatic;

	public ZahlFigur(int zahl, boolean automatic) {
		this.zahl = zahl;
		this.automatic = automatic;
	}

	public ZahlFigur(int zahl) {
		this.zahl = zahl;
		automatic = false;
	}

	@Override
	public char getSymbol() {
		return Character.forDigit(zahl, 10);
	}

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		if (automatic) {
//			g.setColor(Color.ORANGE);
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);
			g.setColor(Color.WHITE);
		} else {
			g.setColor(Color.BLACK);
		}
		g.drawString("" + getSymbol(), xpos * boxBreite + boxBreite / 2, ypos * boxHoehe + boxHoehe / 2);
	}

}
