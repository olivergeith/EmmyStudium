package commonclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Highscore extends ArrayList<Score> {
	private static Highscore instance;
	private static final String FILENAME = "highscores.properties";

	private Highscore() {
		load();
	}

	public static Highscore getInstance() {
		if (instance == null) {
			instance = new Highscore();
		}
		return instance;
	}

	public void load() {
		Properties prop = new Properties();
		try (FileInputStream fi = new FileInputStream(FILENAME)) {
			prop.load(fi);
			clear(); // clears ArrayList

			prop.entrySet().forEach(propEntry -> { // Lambda foreach
				propEntry.getKey(); // Key ist egal
				String hashstring = (String) propEntry.getValue();
				add(new Score(hashstring));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		Properties prop = new Properties();
		this.forEach(score -> {
			prop.put("" + indexOf(score), score.toString());
		});
//		AtomicInteger i = new AtomicInteger(0);
//		this.forEach(score -> {
//			int indexKey = i.incrementAndGet();
//			prop.put("" + indexKey, score.toString());
//		});
//		for (int i = 0; i < size(); i++) {
//			prop.put("" + i, get(i).toString());
//		}
		try (FileOutputStream fo = new FileOutputStream(FILENAME)) {
			prop.store(fo, "");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
