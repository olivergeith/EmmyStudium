package klickspiel.highscore;

public class FischScore {
	String name;
	int sekunden;

	public FischScore(String name, int sekunden) {
		this.name = name;
		this.sekunden = sekunden;
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
