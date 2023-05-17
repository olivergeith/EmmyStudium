package bermudaspiel;

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

//	public void load() {
//
//	}
//
//	public void save() {
//		int key;
//		for (int i = 0; i < size(); i++) {
//			key = i;
//		}
//		String value = prop.setProperty("" + key + value);
//		try {
//			prop.store(new FileOutputStream(filename), "Kommentar");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public void add() {
//		
//	}
}
