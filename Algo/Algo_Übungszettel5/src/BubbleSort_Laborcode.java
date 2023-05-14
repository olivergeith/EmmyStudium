
import static java.util.Arrays.asList;

import java.util.ArrayList;

public class BubbleSort_Laborcode {

	public static void main(String[] args) {

		ArrayList<Integer> liste = new ArrayList<Integer>(asList(2, 23, 8, 40, 6, 56, 4, 83, 45, 2));

		int counter = 0;

		System.out.println("Original Liste: ");
		System.out.println(liste);

		// Maximal so viele Durchläufe wie Liste Elemente hat
		int durchlauf_nr = liste.size() - 1;

		// Variable zum merken, ob noch Vertauschungen aufgetreten sind
		// wird als "wahr" initialisiert
		boolean swapped = true;

		// Solange noch Durchläufe übrig sind und Vertauschungen aufgetreten sind
		// setze Merker zu Vertauschungen auf "Falsch" zurück und...
		while (durchlauf_nr > 0 && swapped == true) {
			swapped = false;
			counter = counter + 2;

			// ...laufe durch die Liste, bis dahin wo noch Vertauschungen auftreten können
			// und vertausche Elemente, falls Links größer als Rechts, setze Merker
			for (int swap_index = 0; swap_index <= durchlauf_nr - 1; swap_index++) {

				if (liste.get(swap_index) > liste.get(swap_index + 1)) {

					liste.add(swap_index, liste.remove(swap_index + 1));
					swapped = true;
					counter = counter + 3;
				}
			}
			durchlauf_nr--;
		}
		System.out.println("Sortierte Liste: ");
		System.out.println(liste);
		System.out.println(counter);
	}
}
