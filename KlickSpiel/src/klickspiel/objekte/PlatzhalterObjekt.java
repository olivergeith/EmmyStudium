package klickspiel.objekte;

import java.awt.Color;
import java.awt.Graphics;

public class PlatzhalterObjekt implements Objekt {

	@Override
	public char getSymbol() {
		return ' ';
	}

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.CYAN);
		g.fillRect(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);
	}

}
