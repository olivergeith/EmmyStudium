package bermudaspiel.figuren;

import java.awt.Color;
import java.awt.Graphics;

public class MarkierungFigur implements Figur {

	@Override
	public char getSymbol() {
		return ' ';
	}

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.blue);
		g.fillOval(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);

	}

}
