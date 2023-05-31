package klickspiel.objekte;

import java.awt.Color;
import java.awt.Graphics;

public class FischObjekt implements Objekt {

	boolean isClicked = false;

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.green);
		g.fillOval(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);
	}

}
