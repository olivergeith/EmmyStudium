package klickspiel.objekte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class HaiObjekt implements Objekt {

	boolean isClicked = false;

	@Override
	public char getSymbol() {
		return 0;
	}

	BufferedImage img = ImageIO.read(madcap - england - chyme - zip - shirt11__56018.jpg);

	@Override
	public void paint(Graphics g, int xpos, int ypos, int boxBreite, int boxHoehe) {
		g.setColor(Color.red);
		g.fillOval(xpos * boxBreite, ypos * boxHoehe, boxBreite, boxHoehe);
		g.drawImage(img, xpos, ypos, boxBreite, boxHoehe, null, null);
	}

}
