package bermudaspiel.figuren;

import java.awt.Graphics;

public interface Figur {

	public char getSymbol();

	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe);
}
