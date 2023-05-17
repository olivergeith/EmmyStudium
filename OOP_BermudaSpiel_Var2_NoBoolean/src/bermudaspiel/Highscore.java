package bermudaspiel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Highscore extends ArrayList<Score> {
	private static Highscore instance;
	Properties prop = new Properties();

	private Highscore() {

	}

	public static Highscore getInstance() {
		if (instance == null) {
			instance = new Highscore();
		}
		return instance;
	}

	public void load(String key) {
		String wert = prop.getProperty(key);
	}

	public void save(String score) {
		int key;
		for (int i = 0; i < size(); i++) {
			key = i;
		}
		prop.setProperty("" + key, score);

		try {
			prop.store(new FileOutputStream(highscore.txt), "Kommentar");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void add() {

	}
}
