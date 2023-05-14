
import java.util.ArrayList;

public class BubbleSortClass {

	public static int sortAndCount(final ArrayList<Integer> liste) {

//		System.out.println("Original Liste: ");
//		System.out.println(liste);

		int countOperations = 0;

		int durchlauf_nr = liste.size() - 1;
		boolean swapped = true;

		while (durchlauf_nr > 0 && swapped == true) {
			swapped = false;
			countOperations = countOperations + 2;

			for (int swap_index = 1; swap_index <= durchlauf_nr; swap_index++) {
				countOperations++;
				if (liste.get(swap_index - 1) > liste.get(swap_index)) {
					countOperations = countOperations + 3;
					;
					liste.add(swap_index, liste.remove(swap_index - 1));
					swapped = true;
					countOperations = countOperations + 2;

				}

			}
			durchlauf_nr--;

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
