package bermudaspiel;

public class Score {
	String name;
	int sekunden;

	public Score(String name, int sekunden) {
		this.name = name;
		this.sekunden = sekunden;
	}

	public String getName() {
		return name;
	}

	public int getSekunden() {
		return sekunden;
	}
}
