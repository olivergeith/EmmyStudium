import java.util.Arrays;

public class ASCIIArtAnimation {

	public static void main(String[] args) throws InterruptedException {

		String[][] artArray = new String[10][25];

		paintShipRecursive(artArray, 0);

	}

	private static void paintShipRecursive(String[][] artArray, int position) throws InterruptedException {

		if (position == 40) {
//			System.out.println("Schiff hat angelegt!");
			position = 0;
//			return;
		}

		// Schiff erstellen und Wellen/Voegel in Position 1 hinzufügen
		paintShip(artArray);
		paintFrame1(artArray, position);

		// Trick, damit Frames verzögert angezeigt werden
		Thread.sleep(300);

		// Wellen/Voegel in Position 2 hinzufügen
		paintFrame2(artArray, position);

		// Trick, damit frames verzögert angezeigt werden
		Thread.sleep(300);

		paintShipRecursive(artArray, position + 1);
		return;

	}

	/********************************************************************************/
	/*
	 * Ab hier: Hilfsfunktionen zur Anzeige des Schiffs mittels eines
	 * mehrdimesionalen Arrays gefüllt mit ASCII Zeichen
	 */
	/********************************************************************************/

	private static void paintShip(String[][] artArray) {

		// ascii art symbole hinzufügen
		for (int i = 0; i < artArray.length; i++) {
			for (int j = 0; j < artArray[0].length; j++) {
				artArray[i][j] = " ";
			}
		}

		Arrays.fill(artArray[7], 2, 22, "_");
		for (int j = 4; j < artArray[0].length - 5; j += 5) {
			artArray[4][j] = "|";
			artArray[7][j] = "|";
		}

		for (int j = 3; j < artArray[0].length - 5; j += 5) {
			artArray[5][j] = ")";
			artArray[5][j + 1] = "_";
			artArray[5][j + 2] = ")";
		}

		for (int j = 2; j < artArray[0].length - 5; j += 5) {
			artArray[6][j] = ")";
			Arrays.fill(artArray[6], j + 1, j + 4, "_");
			artArray[6][j + 4] = ")";
		}

		Arrays.fill(artArray[8], 4, 20, "_");
		artArray[8][2] = "\\";
		artArray[8][21] = "/";

		for (int j = 0; j < artArray[0].length - 5; j += 5) {
			artArray[6][j + 2] = ")";
		}
	}

	private static void paintFrame1(String[][] artArray, int position) {

		// ascii art symbole hinzufügen
		Arrays.fill(artArray[1], 10, 12, "~");
		Arrays.fill(artArray[2], 5, 8, "~");
		Arrays.fill(artArray[3], 9, 11, "~");
		Arrays.fill(artArray[1], 2, 3, "~");

		Arrays.fill(artArray[1], 10, 12, " ");
		Arrays.fill(artArray[1], 5, 8, " ");
		Arrays.fill(artArray[2], 9, 11, " ");
		Arrays.fill(artArray[0], 2, 3, " ");

		for (int j = 0; j < artArray[0].length - 5; j += 5) {
			Arrays.fill(artArray[9], j + 1, j + 4, "^^");
			Arrays.fill(artArray[9], j + 3, j + 6, " ");
		}

		Arrays.fill(artArray[8], 24, 25, "~ ~");
		Arrays.fill(artArray[8], 0, 1, " ");
		Arrays.fill(artArray[8], 23, 24, " ");

		// für Abstand zwischen Schiffen Leerzeilen einfügen
		for (int i = 0; i < 5; i++) {
			System.out.println();
		}

		// für seitwärts Bewegung: mit offset drucken
		String offset1 = "  ";
		String offset = "  ";

		for (int l = 0; l <= position; l++) {
			offset = offset + offset1;
		}

		// für auf-abwärts Bewegung: zwischendruch extra Zeile drucken
		if (position % 3 == 0) {
			System.out.println();
		}

		// Schiff drucken
		for (int i = 0; i < artArray.length; i++) {
			System.out.println(offset + String.join("", artArray[i]));
		}
	}

	private static void paintFrame2(String[][] artArray, int position) {

		// ascii art symbole hinzufügen
		Arrays.fill(artArray[1], 10, 12, "~");
		Arrays.fill(artArray[1], 5, 8, "~");
		Arrays.fill(artArray[2], 9, 11, "~");
		Arrays.fill(artArray[0], 2, 3, "~");

		Arrays.fill(artArray[1], 10, 12, " ");
		Arrays.fill(artArray[2], 5, 8, " ");
		Arrays.fill(artArray[3], 9, 11, " ");
		Arrays.fill(artArray[1], 2, 3, " ");

		for (int j = 2; j < artArray[0].length - 5; j += 5) {
			Arrays.fill(artArray[9], j + 1, j + 4, "^^");
			artArray[6][j + 4] = ")";
		}

		for (int j = 0; j < artArray[0].length - 5; j += 5) {
			Arrays.fill(artArray[9], j + 2, j + 5, "^^");
			Arrays.fill(artArray[9], j + 1, j + 4, " ");
		}

		Arrays.fill(artArray[8], 23, 24, "~");

		Arrays.fill(artArray[8], 0, 1, "~");
		Arrays.fill(artArray[8], 24, 25, " ");

		// für Abstand zwischen Schiffen Leerzeilen einfügen
		for (int i = 0; i < 5; i++) {
			System.out.println();
		}

		// für seitwärts Bewegung: mit offset drucken
		String offset = "  ";
		String offset1 = "  ";

		for (int l = 0; l <= position; l++) {
			offset = offset + offset1;
		}

		// Schiff drucken
		for (int i = 0; i < artArray.length; i++) {
			System.out.println(offset + String.join("", artArray[i]));
		}

		// für auf-abwärts Bewegung: zwischendruch extra Zeile drucken
		if (position % 3 == 0) {
			System.out.println();
		}
	}
}
