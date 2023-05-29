package klickspiel;

public class Koordinate {
	private int x;
	private int y;

	public Koordinate(int wert1, int wert2) {
		x = wert1;
		y = wert2;
	}

	@Override
	public String toString() {
		String xString = "" + x;
		String yString = "" + y;
		return xString + " , " + yString;
	}

	public boolean equals(Koordinate koord) {
		if (this.x == koord.x && this.y == koord.y) {
			return true;
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
