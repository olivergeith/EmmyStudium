import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TowersofHanoi {

	public static Map<Character, List<Integer>> tuerme = new HashMap<>();

	public static void Turmbewegung(int n, char quelle, char senke, char ab) {
		if (n == 1) {
			bewegeScheibe(quelle, senke);
			System.out.println("Move disc from " + quelle + " to " + senke);
			printTowers(tuerme);
		} else {
			Turmbewegung(n - 1, quelle, ab, senke);
			bewegeScheibe(quelle, senke);
			System.out.println("Move disc from " + quelle + " to " + senke);
			printTowers(tuerme);
			Turmbewegung(n - 1, ab, senke, quelle);
		}

		// Hilfe: Um die Bewegung und Tuerme auf Konsole drucken, nutzen Sie
//		System.out.println("Move disc from " + quelle + " to " + senke);
//		printTowers(tuerme);

	}

	public static void bewegeScheibe(char quelle, char senke) {
		// Quelle und Senke aus HashMap holen
		List<Integer> sourceTower = tuerme.get(quelle);
		List<Integer> destinationTower = tuerme.get(senke);

		// Oberstes Element der Quelle zur Senke bewegen
		destinationTower.add(sourceTower.remove(sourceTower.size() - 1));
	}

	/************************************************************************/

	/************************************************************************/
	/*
	 * Main Methode - ab hier sollte nichts mehr am Code verändert werden, mit
	 * Ausnahme des Parameters n, für welchen unterschiedliche Turmhöhen eingesetzt
	 * werden sollten
	 */
	/************************************************************************/

	public static void main(String[] args) {

		// n gibt die Höhe des Turms an. Kann beliebig verändert werden
		int n = 4;

		// Initiales Anlegen der 3 Bereiche A, B, C als HashMap.
		// Hinter jedem der 3 Schlüssel wird zunächst eine leere Liste
		// angelegt, welche später die Scheiben als Zahlen simuliert.

		// Map<Character, List<Integer>> towers = new HashMap<>();
		tuerme.put('A', new ArrayList<>());
		tuerme.put('B', new ArrayList<>());
		tuerme.put('C', new ArrayList<>());

		// Initiales Füllen des Turmes im Bereich A
		// Die Größe der Scheibe wird durch die Größe der Zahl i simuliert
		for (int i = n; i > 0; i--) {
			tuerme.get('A').add(i);
		}

		// Anzeigen des Inhalts der drei Bereiche/Türme auf der Konsole
		printTowers(tuerme);
		Turmbewegung(n, 'A', 'B', 'C');
	}

	/**************************************************************/
	/*
	 * Ab hier: Hilfsfunktionen, die nicht verändert werden sollten. Bereits fertig
	 * implementiert, um die Türme in einfacher Form auf der Konsole anzuzeigen.
	 */
	/**************************************************************/

	public static void printTowers(Map<Character, List<Integer>> towers) {
		int maxHeight = getMaxHeight(towers);
		for (int i = 1; i <= maxHeight; i++) {
			String row = "";
			for (char key : towers.keySet()) {
				List<Integer> tower = towers.get(key);
				String disc = " ";
				int discIndex = tower.size() - i;
				if (discIndex >= 0) {
					disc = Integer.toString(tower.get(discIndex));
				}
				row += "  " + disc + "  ";
			}
			System.out.println(row);
		}
		System.out.println(" A   B   C");
		System.out.println("-----------");
	}

	public static int getMaxHeight(Map<Character, List<Integer>> towers) {
		int maxHeight = 0;
		for (char key : towers.keySet()) {
			List<Integer> tower = towers.get(key);
			if (tower.size() > maxHeight) {
				maxHeight = tower.size();
			}
		}
		return maxHeight;
	}

}
