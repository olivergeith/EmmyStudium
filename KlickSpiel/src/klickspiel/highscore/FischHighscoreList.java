package klickspiel.highscore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class FischHighscoreList extends ArrayList<FischScore> {
	private static final long serialVersionUID = 1L;
	private static FischHighscoreList instance;
	private final static String dateiname = "highscoreslist.properties";

	private FischHighscoreList() {
		load();
	}

	public static FischHighscoreList getInstance() {
		if (instance == null) {
			instance = new FischHighscoreList();
		}
		return instance;
	}

	public void load() {
		Properties prop = new Properties();
		try (FileInputStream fi = new FileInputStream(dateiname)) {
			prop.load(fi);
			clear(); // clears ArrayList

			prop.entrySet().forEach(propEntry -> { // Lambda foreach
				propEntry.getKey(); // Key ist egal
				String hashstring = (String) propEntry.getValue();
				add(new FischScore(hashstring));
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
		try (FileOutputStream fo = new FileOutputStream(dateiname)) {
			prop.store(fo, "");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
