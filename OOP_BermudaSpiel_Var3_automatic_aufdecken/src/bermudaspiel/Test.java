package bermudaspiel;

public class Test {

	public static void main(String[] args) {
		final int ANZAHL = 10;
		final int X = 9;
		final int Y = 7;
		Flotte flotte = new Flotte(ANZAHL, X, Y);
		for (int i = 0; i < ANZAHL; i++) {
			System.out.println(flotte.get(i));
		}

	}

}
