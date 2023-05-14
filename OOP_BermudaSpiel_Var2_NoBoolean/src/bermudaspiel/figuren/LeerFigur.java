package bermudaspiel.figuren;

import java.awt.Color;
import java.awt.Graphics;

public class LeerFigur implements Figur {

	@Override
	public char getSymbol() {
		return ' ';
	}

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.WHITE);
		g.fillOval(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);
		g.setColor(Color.BLACK);
		g.drawOval(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);

	}

}
