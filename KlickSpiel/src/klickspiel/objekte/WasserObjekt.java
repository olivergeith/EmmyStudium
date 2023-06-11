package klickspiel.objekte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import klickspiel.swing.ImageLoader;

public class WasserObjekt implements Objekt {

	@Override
	public char getSymbol() {
		return ' ';
	}

	ImageLoader load = new ImageLoader();
	BufferedImage img = load.loadImage("Wellen.png");

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.CYAN);
		g.fillRect(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);
		g.drawImage(img, xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe, Color.cyan, null);
	}

}
