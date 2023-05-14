package DebuggingLabor;

public class DebuggingLabor_Aufgabe1 {

	public static void main(String[] args) {

		/************** Array Implementierung ****************/
		// Algorithmus zur Palindrom Erkennung mittels Array

		String wort = "Lagerregal";

		// Palindrome zum Testen
		// String wort = "Lagerregal";
		// String wort = "Reittier";
		// String wort = "Rentner";

		wort = wort.toLowerCase();

		char[] wortArray = wort.toCharArray();

		boolean isPalindrom = false;

		for (int i = 0; i < wortArray.length; i++) {

			if (wortArray[i] != wortArray[(wortArray.length - 1) - i]) {
				isPalindrom = false;
				break;
			} else {
				isPalindrom = true;
			}
		}
		if (isPalindrom == true) {
			System.out.println("Das Wort " + wort + " ist ein Palindrom (Array-Methode)");
		} else {
			System.out.println("Das Wort " + wort + " ist kein Palindrom (Array-Methode)");
		}
	}
}
