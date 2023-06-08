import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Breitensuchlauf {

	/**
	 * @param graph
	 * @param startknoten
	 * @return the distances to all nodes from the startnode.
	 */
	public static int[] breitensuche(Graph_Adjazenzmatrix graph, int startknoten) {
		final Queue<Integer> queue = new LinkedList<>();
		final int anzahlNodes = graph.numVertices;
		final int[] predecessor = new int[anzahlNodes];
		final boolean besucht[] = new boolean[anzahlNodes];
		final int[] distances = new int[anzahlNodes];

		besucht[startknoten] = true;
		predecessor[startknoten] = -1;
		queue.add(startknoten);

		while (!queue.isEmpty()) {
			final int node = queue.remove();
//			System.out.println("Removing node " + node);

			for (int otherNode = 0; otherNode < anzahlNodes; otherNode++) {
				if (graph.isVerbunden(node, otherNode) && besucht[otherNode] == false) {
					besucht[otherNode] = true;
					predecessor[otherNode] = node;
					distances[otherNode] = distances[node] + 1;
					queue.add(otherNode);
//					System.out.println("Visiting node " + otherNode + ", setting its distance to "
//							+ distances[otherNode] + " and adding it to the queue");

				}
			}
		}
//		System.out.println("predecessor: " + Arrays.toString(predecessor));
		return distances;
	}

	/**
	 * @param graph
	 * @param startknoten
	 * @param zielKnoten
	 * @return the distances to zielknoten from the startnode.
	 */
	public static int breitensuche(Graph_Adjazenzmatrix graph, int startknoten, int zielKnoten) {
		final int[] distances = breitensuche(graph, startknoten);
		return distances[zielKnoten];

	}

	public static void main(String[] args) {
		final int numVertices = 5;
		final Graph_Adjazenzmatrix graph = new Graph_Adjazenzmatrix(numVertices);

		graph.addEdge(0, 1);
//		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
//		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		graph.printGraph();

		final int startknoten = 0;

//		final int[] distances = breitensuche(graph, startknoten);
		final int[] distances = graph.breitensuche(startknoten);

		System.out.println("Distances: " + Arrays.toString(distances));

		System.out.println("Distance 0 to 3 = " + breitensuche(graph, 0, 3));

		System.out.println("Distance 0 to 4 = " + breitensuche(graph, 0, 4));
		System.out.println("Distance 1 to 4 = " + breitensuche(graph, 1, 4));
		System.out.println("Distance 2 to 4 = " + breitensuche(graph, 2, 4));
		System.out.println("Distance 3 to 4 = " + breitensuche(graph, 3, 4));

	}

}
