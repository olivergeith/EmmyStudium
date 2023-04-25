package bermudaspiel.figuren;

import java.awt.Color;
import java.awt.Graphics;

public interface Figur {

	public char getSymbol();

	default void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.black);
		g.drawString("" + getSymbol(), xpos * boxBreite + boxBreite / 2, ypos * boxHoehe + boxHoehe / 2);

	}
}
