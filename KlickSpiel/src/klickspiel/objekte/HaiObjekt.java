package klickspiel.objekte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import klickspiel.swing.ImageLoader;

public class HaiObjekt implements Objekt {

	boolean isClicked = false;

	public int lives = 5;

	@Override
	public char getSymbol() {
		return 0;
	}

	ImageLoader load = new ImageLoader();
	BufferedImage img = load.loadImage("Hai.png");

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.red);
		g.fillOval(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);
		g.drawImage(img, xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe, Color.cyan, null);
	}

}
