
import java.util.ArrayList; //Import ArrayLists 

public class InsertionSortClass {

	public static int sortAndCount(final ArrayList<Integer> liste) {

//		System.out.println("Original Liste: ");
//		System.out.println(liste);

		int countOperations = 0;

		for (int currentNumber_index = 1; currentNumber_index < liste.size(); ++currentNumber_index) {
			countOperations++;
			int previousNumber_index = currentNumber_index;

			while (previousNumber_index > 0 && (liste.get(currentNumber_index) < liste.get(previousNumber_index - 1))) {
				countOperations = countOperations + 4;
				previousNumber_index--;

			}
			liste.add(previousNumber_index, liste.remove(currentNumber_index));
			countOperations = countOperations + 2;
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
