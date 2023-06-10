package klickspiel.objekte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import klickspiel.swing.ImageLoader;

public class FischObjekt implements Objekt {

	boolean isClicked = false;

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return 0;
	}

	ImageLoader load = new ImageLoader();
	BufferedImage img = load.loadImage("400px-Fish.png");

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.green);
		g.fillOval(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);
		g.drawImage(img, xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe, Color.cyan, null);
	}

}
