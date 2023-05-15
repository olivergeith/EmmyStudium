package bermudaspiel;

import java.util.ArrayList;

public class Highscore extends ArrayList<Score> {
	private static Highscore instance;

	private Highscore() {

	}

	public static Highscore getInstance() {
		if (instance == null) {
			instance = new Highscore();
		}
		return instance;
	}
}
