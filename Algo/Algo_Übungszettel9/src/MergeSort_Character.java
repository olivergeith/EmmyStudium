
import java.util.LinkedList;

public class MergeSort_Character {

	/* Hilfsfunktion Merge */
	public static LinkedList<Character> merge(LinkedList<Character> liste1, LinkedList<Character> liste2) {

		LinkedList<Character> result = new LinkedList<Character>();

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
	public static LinkedList<Character> mergeSort(LinkedList<Character> liste) {
		LinkedList<Character> left = new LinkedList<Character>();
		LinkedList<Character> right = new LinkedList<Character>();

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
		LinkedList<Character> liste1 = new LinkedList<Character>();
		liste1.add('a');
		liste1.add('c');
		liste1.add('e');
		liste1.add('f');

		LinkedList<Character> liste2 = new LinkedList<Character>();
		liste2.add('b');
		liste2.add('c');
		liste2.add('e');
		liste2.add('g');
		liste2.add('j');

		System.out.print("####Testen der Hilfsfunktion Merge####\n");
		System.out.print("Eingangsliste 1:\n");
		System.out.print(liste1 + "\n");

		System.out.print("Eingangsliste 2:\n");
		System.out.print(liste2 + "\n");

		System.out.print("Ergebnis von Merge\n");
		System.out.print(merge(liste1, liste2) + "\n");

		LinkedList<Character> liste = new LinkedList<Character>();
		liste.add('d');
		liste.add('z');
		liste.add('f');
		liste.add('p');
		liste.add('e');
		liste.add('f');
		liste.add('s');
		liste.add('a');
		liste.add('x');

		System.out.print("\n####Testen der MergeSort Implementierung####\n");
		System.out.print("Unsortierte Eingangsliste:\n");
		System.out.print(liste);
		System.out.println();

		System.out.print("Ergebnis MergeSort:\n");

		LinkedList<Character> sortedList = mergeSort(liste);

		System.out.print(sortedList);

	}
}
