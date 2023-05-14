package bermudaspiel.figuren;

import java.awt.Color;
import java.awt.Graphics;

public class ZahlFigur implements Figur {
	int zahl;

	public ZahlFigur(int zahl) {
		this.zahl = zahl;
	}

	@Override
	public char getSymbol() {
		return Character.forDigit(zahl, 10);
	}

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.black);
		g.drawString("" + getSymbol(), xpos * boxBreite + boxBreite / 2, ypos * boxHoehe + boxHoehe / 2);

	}

}
