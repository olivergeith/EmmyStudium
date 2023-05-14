import static java.util.Arrays.asList;

import java.util.ArrayList;

public class AufgabeInsertionSort {

	public static void main(String[] args) {
		ArrayList<Integer> liste = new ArrayList<Integer>(asList(3, 5, 1, 6, 2, 4));

		System.out.println("Original Liste: ");
		System.out.println(liste);
		Integer currentNumber;
		Integer prevNumber;
		int counter = 0;

		for (int i = 0; i < liste.size(); i++) {

			currentNumber = liste.get(i);

			Integer j = i;

			while (j > 0) {

				prevNumber = liste.get(j - 1);

				if (currentNumber < prevNumber) {

					break;
				}
				j--;
			}

			liste.add(j, liste.remove(i));
			counter++;
		}
		System.out.println("Sortierte Liste: ");
		System.out.println(liste);
		System.out.println(counter);
	}

}
