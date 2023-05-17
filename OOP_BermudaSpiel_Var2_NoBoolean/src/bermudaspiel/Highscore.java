package bermudaspiel;

import java.util.ArrayList;
import java.util.Properties;

public class Highscore extends ArrayList<Score> {
	private static Highscore instance;
	Properties prop = new Properties();

	private Highscore() {
//		try {
//			prop.load(new FileInputStream(highscore.txt));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public static Highscore getInstance() {
		if (instance == null) {
			instance = new Highscore();
		}
		return instance;
	}

	public String load(String key) {
		String highscore = prop.getProperty(key);
		return highscore;
	}

	public void save(String score) {
		int key = 0;
		for (int i = 0; i < size(); i++) {
			key = i;
		}
		prop.setProperty("" + key, score);
	}

	public void add() {

	}
}
