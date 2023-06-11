package klickspiel.highscore;

public class FischScore {
	String name;
	int sekunden;

	public FischScore(String name, int sekunden) {
		this.name = name;
		this.sekunden = sekunden;
	}

	public FischScore(String hashstring) {
		String[] split = hashstring.split("#");
		if (split.length != 2) {
			throw new IllegalArgumentException("Fehlerhafter Hashstring");
		}
		this.name = split[0];
		this.sekunden = Integer.parseInt(split[1]);
	}

	public String getName() {
		return name;
	}

	public int getSekunden() {
		return sekunden;
	}

	@Override
	public String toString() {
		return name + "#" + sekunden;
	}

}
