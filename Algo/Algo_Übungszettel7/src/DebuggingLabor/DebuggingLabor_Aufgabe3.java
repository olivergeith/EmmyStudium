package DebuggingLabor;

import java.util.LinkedList;
import java.util.ListIterator;

public class DebuggingLabor_Aufgabe3 {

	public static void main(String[] args) {

		/************** Linked List Implementierung ****************/
		// Algorithmus zur Palindrom Erkennung mittels Linked List und Iterator

		String wort = "Rentner";

		// Palindrome zum Testen
		// String wort = "Lagerregal";
		// String wort = "Reittier";
		// String wort = "Rentner";

		wort = wort.toLowerCase();

		LinkedList<Character> wortListeLinked = convertWordToList(wort);

		ListIterator<Character> listeIteratorStart = wortListeLinked.listIterator();
		ListIterator<Character> listeIteratorEnd = wortListeLinked.listIterator(wortListeLinked.size());

		Character buchstabe1 = null;
		Character buchstabe2 = null;

		while (listeIteratorStart.hasNext() && listeIteratorEnd.hasPrevious() && buchstabe1 == buchstabe2) {
			buchstabe1 = listeIteratorStart.next();
			buchstabe2 = listeIteratorEnd.previous();
		}

		if (listeIteratorStart.nextIndex() < wortListeLinked.size()) {
			System.out.println("Das Wort " + wort + " ist kein Palindrom (Iterator-Methode)");
		} else {
			System.out.println("Das Wort " + wort + " ist ein Palindrom (Iterator-Methode)");
		}
	}

	private static LinkedList<Character> convertWordToList(String wort) {

		LinkedList<Character> linkedList = new LinkedList<Character>();

		for (int i = 0; i < wort.length(); i++) {
			linkedList.addFirst(wort.charAt(i));
		}

		return linkedList;
	}
}
