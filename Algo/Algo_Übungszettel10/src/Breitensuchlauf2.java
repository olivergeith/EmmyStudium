import java.util.LinkedList;
import java.util.Queue;

public class Breitensuchlauf2 {

	public static Graph_Adjazenzmatrix breitensuche(Graph_Adjazenzmatrix graph, int startknoten) {
		final Queue<Integer> queue = new LinkedList<>();
		final int anzahlNodes = graph.numVertices;
		final int[] predecessor = new int[anzahlNodes];
		final boolean besucht[] = new boolean[anzahlNodes];
		Graph_Adjazenzmatrix baum = new Graph_Adjazenzmatrix(anzahlNodes);

		besucht[startknoten] = true;
		predecessor[startknoten] = -1;
		queue.add(startknoten);

		while (!queue.isEmpty()) {
			final int node = queue.remove();

			for (int otherNode = 0; otherNode < anzahlNodes; otherNode++) {
				if (graph.isVerbunden(node, otherNode) && besucht[otherNode] == false) {
					besucht[otherNode] = true;
					predecessor[otherNode] = node;
					queue.add(otherNode);
					baum.addEdge(predecessor[otherNode], otherNode);

				}
			}
		}
		return baum;
	}

	public static void main(String[] args) {
		final int numVertices = 5;
		final Graph_Adjazenzmatrix graph = new Graph_Adjazenzmatrix(numVertices);

		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		graph.printGraph();

		final int startknoten = 0;

		Graph_Adjazenzmatrix baum = breitensuche(graph, startknoten);
		System.out.println("Breitensuchbaum: ");
		baum.printGraph();

	}

}
