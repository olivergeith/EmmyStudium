package klickspiel.swing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	BufferedImage img = null;

	public BufferedImage loadImage(String source) {
		{
			try {
				img = ImageIO.read(new File(source));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}

}
