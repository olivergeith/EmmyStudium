package bermudaspiel;

import bermudaspiel.figuren.Schiff;

public class Flotte {
	Schiff schiffe[];

	public Flotte(int AnzahlSchiffe, int X, int Y) {

		schiffe = new Schiff[AnzahlSchiffe];

		java.util.Random zufall = new java.util.Random();

		for (int i = 0; i < schiffe.length; i++) {
			Schiff Koord = new Schiff(zufall.nextInt(X), zufall.nextInt(Y));
			schiffe[i] = Koord;
			for (int j = 0; j < i; j++) {
				if (schiffe[i].equals(schiffe[j])) {
					i--;
				}
			}

		}
	}

	public Schiff get(int i) {
		return this.schiffe[i];
	}

	public boolean istHierSchiff(Koordinate k) {
		for (int i = 0; i < schiffe.length; i++) {
			if (schiffe[i].equals(k)) {
				return true;
			}
		}
		return false;
	}

	public Schiff getSchiff(Koordinate k) {
		for (int i = 0; i < schiffe.length; i++) {
			if (schiffe[i].equals(k)) {
				return schiffe[i];
			}
		}
		return null;
	}

	public Schiff[] getSchiffe() {
		return schiffe;
	}

}
