package klickspiel.objekte;

import java.awt.Graphics;

public interface Objekt {

	public char getSymbol();

	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe);
}
