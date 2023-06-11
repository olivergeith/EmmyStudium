package klickspiel.objekte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import klickspiel.swing.ImageLoader;

public class FischObjekt implements Objekt {

	boolean isClicked = false;

	public int lives = 5;

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return 0;
	}

	ImageLoader load = new ImageLoader();
	BufferedImage fish1 = load.loadImage("Fisch1.png");
	BufferedImage fish2 = load.loadImage("Fisch2.png");
	BufferedImage fish3 = load.loadImage("Fisch3.png");
	BufferedImage fish4 = load.loadImage("Fisch4.png");
	BufferedImage fish5 = load.loadImage("Fisch5.png");

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.green);
		if (lives == 5) {
			g.drawImage(fish1, xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe, Color.cyan, null);
		}
		if (lives == 4) {
			g.drawImage(fish2, xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe, Color.cyan, null);
		}
		if (lives == 3) {
			g.drawImage(fish3, xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe, Color.cyan, null);
		}
		if (lives == 2) {
			g.drawImage(fish4, xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe, Color.cyan, null);
		}
		if (lives == 1) {
			g.drawImage(fish5, xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe, Color.cyan, null);
		}
	}

}
