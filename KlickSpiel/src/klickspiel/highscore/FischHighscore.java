package klickspiel.highscore;

import java.util.ArrayList;
import java.util.Properties;

public class FischHighscore extends ArrayList<FischScore> {
	private static final long serialVersionUID = 1L;
	private static FischHighscore instance;
	Properties prop = new Properties();

	private FischHighscore() {
//		try {
//			prop.load(new FileInputStream(highscore.txt));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public static FischHighscore getInstance() {
		if (instance == null) {
			instance = new FischHighscore();
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
