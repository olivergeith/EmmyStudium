package klickspiel.objekte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import klickspiel.swing.ImageLoader;

public class HaiObjekt implements Objekt {

	boolean isClicked = false;

	@Override
	public char getSymbol() {
		return 0;
	}

	ImageLoader load = new ImageLoader();
	BufferedImage img = load.loadImage("pngtree-great-white-shark-vector-png-image_8925224.png");

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.red);
		g.fillOval(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);
		g.drawImage(img, xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe, Color.cyan, null);
	}

}
