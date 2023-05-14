
import java.util.Stack;

public class StackLabor {

	public static void main(final String[] args) {

		// Palindrome zum Testen
		// String myLetter = "Lagerregal";
		// String myLetter = "Reittier";
		// String myLetter = "Rentner";

		final String myLetter = "Rentner";

		/************** Stack Implementierung ****************/
		final Stack<Character> reverseStack = new Stack<Character>();

		String wort = myLetter.toLowerCase();

		// gehe durch Wort und füge Buchstaben zum Stack (push)
		for (int i = 0; i < myLetter.length(); i++) {

			reverseStack.push(wort.charAt(i));
			// Hinweise:
			// stapel.push(element) fügt element auf stapel
			// wort.charAt(i) gibt den Buchstaben von wort an Stelle i
			// buchstabe.toLowerCase() wandelt den Buchstaben in Kleinbuchstaben
		}

		// Rückgabewert initiieren
		boolean is_palindrome = true;

		// gehe durch Wort und vergleiche mit vom Stapel genommenen Element (pop)
		for (int i = 0; i < myLetter.length(); i++) {
			// HIER CODE ERGÄNZEN
			if (wort.charAt(i) != reverseStack.pop()) {
				is_palindrome = false;
				break;
			}
			// Hinweise:
			// stapel.pop() nimmt oberstes Element von stapel und gibt dies zurück
			// wort.charAt(i) gibt den Buchstaben von wort an Stelle i
			// buchstabe.toLowerCase() wandelt den Buchstaben in Kleinbuchstaben

		}
		if (is_palindrome == true) {
			System.out.println("Das Wort " + myLetter + " ist ein Palindrom: ");
		} else {
			System.out.println("Das Wort " + myLetter + " ist kein Palindrom: ");
		}

		System.out.println(is_palindrome);

	}
}
