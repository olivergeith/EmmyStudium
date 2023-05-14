
import static java.util.Arrays.asList;

import java.util.ArrayList;

public class SelectionSort_Laborcode {

	// Hilfsfunktion für Min finden
	private static int findMinIndex(ArrayList<Integer> liste, int start) {

		// setzte Minimum auf Wert am Startpunkt der Liste
		int currentMin_value = liste.get(start);
		// setzte Position des Minimums auf Wert am Startpunkt der Liste
		int min_index = start;

		// Laufe durch Liste vom Start bis Ende und
		// falls kleiner, ersetze Minimum und Minimum Index
		for (int i = start; i < liste.size(); i++) {
			if (liste.get(i) < currentMin_value) {
				currentMin_value = liste.get(i);
				min_index = i;
			}
		}
		return min_index;
	}

	public static void main(String[] args) {

		ArrayList<Integer> liste = new ArrayList<Integer>(asList(5, 10, -100, 15, -4, 20, 8, 14, 1));

		System.out.println("Original Liste: ");
		System.out.println(liste);

		int minIndex;

		// Laufe durch Liste, finde Index des Minimum Elements in aktuellem Abschnitt
		// und
		// setze das Mimimum Element an die aktuelle Anfangsposition
		for (int start_index = 0; start_index < liste.size(); ++start_index) {
			minIndex = findMinIndex(liste, start_index);
			liste.add(start_index, liste.remove(minIndex));
		}
		System.out.println("Sortierte Liste: ");
		System.out.println(liste);
	}
}
