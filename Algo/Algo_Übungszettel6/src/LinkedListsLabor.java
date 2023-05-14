
import java.util.LinkedList;

public class LinkedListsLabor {

	public static void main(final String[] args) {

		final LinkedList<String> listeLinks = new LinkedList<String>();

		listeLinks.add("zusammengefuegt.");
		listeLinks.add("richtigen");
		listeLinks.add("in");
		listeLinks.add("Listen");
		listeLinks.add("Die");

		final LinkedList<String> listeRechts = new LinkedList<String>();

		listeRechts.add("verketteten");
		listeRechts.add("wurden");
		listeRechts.add("der");
		listeRechts.add("Reihenfolge");

		final LinkedList<String> listeMerged = new LinkedList<String>();

		// Längste der zwei Listen identifizieren
		int max;
		if (listeLinks.size() > listeRechts.size()) {
			max = listeLinks.size();
		} else {
			max = listeRechts.size();
		}

		// Listen richtig zusammenfügen
		String wortLinks;
		String wortRechts;

		for (int i = 0; i < max; i++) {
			// HIER CODE ERGÄNZEN
			if (listeLinks.peekLast() == null) {
				break;
			}
			if (listeRechts.peekFirst() == null) {
				break;
			}
			wortLinks = listeLinks.removeLast();
			wortRechts = listeRechts.removeFirst();
			listeMerged.add(wortLinks);
			listeMerged.add(wortRechts);
			// Hinweise:
			// liste.peekFirst() schaut nach dem ersten Element und gibt null zurück,
			// falls die Liste leer ist. Analog dazu ist liste.peekLast()
			// liste.removeLast() entfernt das letzte Element und gibt es zurück.
			// Analog dazu ist liste.removeFirst()
		}

		System.out.println(listeMerged);
	}
}
