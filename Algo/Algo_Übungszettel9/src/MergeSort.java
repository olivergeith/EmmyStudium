
import java.util.LinkedList;

public class MergeSort {

	/* Hilfsfunktion Merge */
	public static LinkedList<Integer> merge(LinkedList<Integer> liste1, LinkedList<Integer> liste2) {

		LinkedList<Integer> result = new LinkedList<Integer>();

		while (liste1.size() != 0 && liste2.size() != 0) {
			if (liste1.get(0) < liste2.get(0)) {
				result.add(liste1.remove(0));
			} else {
				result.add(liste2.remove(0));
			}
		}
		while (liste1.size() != 0) {
			result.add(liste1.remove(0));
		}
		while (liste2.size() != 0) {
			result.add(liste2.remove(0));
		}
		return result;
	}

	/* MergeSort Implementierung inkl. Rekursion */
	public static LinkedList<Integer> mergeSort(LinkedList<Integer> liste) {
		LinkedList<Integer> left = new LinkedList<Integer>();
		LinkedList<Integer> right = new LinkedList<Integer>();

		if (liste.size() == 1) {
			return liste;
		}

		int half = liste.size() / 2;
		for (int i = 0; i < half; i++) {
			left.add(liste.remove(0));
		}
		while (!liste.isEmpty()) {
			right.add(liste.remove(0));
		}

		left = mergeSort(left);
		right = mergeSort(right);

		return merge(left, right);
	}

	/* Main Methode - braucht nicht verändert werden */
	public static void main(String[] args) {
		LinkedList<Integer> liste1 = new LinkedList<Integer>();
		liste1.add(3);
		liste1.add(6);
		liste1.add(10);
		liste1.add(12);

		LinkedList<Integer> liste2 = new LinkedList<Integer>();
		liste2.add(4);
		liste2.add(9);
		liste2.add(12);
		liste2.add(15);
		liste2.add(20);

		System.out.print("####Testen der Hilfsfunktion Merge####\n");
		System.out.print("Eingangsliste 1:\n");
		System.out.print(liste1 + "\n");

		System.out.print("Eingangsliste 2:\n");
		System.out.print(liste2 + "\n");

		System.out.print("Ergebnis von Merge\n");
		System.out.print(merge(liste1, liste2) + "\n");

		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(5);
		liste.add(2);
		liste.add(9);
		liste.add(1);
		liste.add(6);
		liste.add(3);
		liste.add(8);
		liste.add(4);
		liste.add(7);

		System.out.print("\n####Testen der MergeSort Implementierung####\n");
		System.out.print("Unsortierte Eingangsliste:\n");
		System.out.print(liste);
		System.out.println();

		System.out.print("Ergebnis MergeSort:\n");

		LinkedList<Integer> sortedList = mergeSort(liste);

		System.out.print(sortedList);

	}
}
