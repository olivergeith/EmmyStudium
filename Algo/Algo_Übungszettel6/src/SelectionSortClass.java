
import java.util.ArrayList;

public class SelectionSortClass {

	private static int findMinIndex(final ArrayList<Integer> liste, final int start_index) {

		int currentMin_value = liste.get(start_index);
		int currentMin_index = start_index;

		for (int i = start_index; i < liste.size(); i++) {
			if (liste.get(i) < currentMin_value) {
				currentMin_value = liste.get(i);
				currentMin_index = i;

			}
		}
		return currentMin_index;
	}

	private static int findMinIndex_countOperationsSteps(final ArrayList<Integer> liste, final int start) {

		int countOperations = 0;
		int currentMin_value = liste.get(start);
		countOperations++;
		for (int i = start; i < liste.size(); i++) {
			countOperations++;
			if (liste.get(i) < currentMin_value) {
				currentMin_value = liste.get(i);
				countOperations = countOperations + 3;

			}

		}

		return countOperations;
	}

	public static int sortAndCount(final ArrayList<Integer> liste) {

//		System.out.println("Original Liste: ");
//		System.out.println(liste);

		int countOperations = 0;

		int minIndex;

		for (int start_index = 0; start_index < liste.size(); ++start_index) {
			minIndex = findMinIndex(liste, start_index);
			// Nutze Hilfsmethode zum Zählen der Operationen von FindMaxIndex
			countOperations += findMinIndex_countOperationsSteps(liste, start_index);

			liste.add(start_index, liste.remove(minIndex));
		}
		/*
		 * System.out.println("Sortierte Liste: "); System.out.println(liste);
		 * 
		 * System.out.println("Anzahl Operations: ");
		 * System.out.println(countOperations);
		 */

		return countOperations;
	}
}
