package DebuggingLabor;

public class DebuggingLabor_Aufgabe2 {

	public static void main(String[] args) {

		/************** Index Implementierung ****************/
		// Algorithmus zur Palindrom Erkennung mittels Index

		String wort = "Lagerregal";

		// Palindrome zum Testen
		// String wort = "Lagerregal";
		// String wort = "Reittier";
		// String wort = "Rentner";

		boolean is_palindrome = true;

		int start_index = 0;
		int end_index = wort.length() - 1;

		wort = wort.toLowerCase();

		char buchstabe1;
		char buchstabe2;

		while (end_index > start_index) {
			buchstabe1 = wort.charAt(start_index);
			buchstabe2 = wort.charAt(end_index);

			if (buchstabe1 != buchstabe2) {
				is_palindrome = false;
				break;
			}
			start_index++;
			end_index--;
		}
		System.out.println("Das Wort " + wort + " ist ein Palindrom (Index-Methode): " + is_palindrome);
	}
}
