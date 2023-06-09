public class Graph_Adjazenzmatrix {
	int numVertices;
	private final int[][] adjacencyMatrix;

	/* Klassen Konstruktor */
	public Graph_Adjazenzmatrix(int numVertices) {
		this.numVertices = numVertices;
		adjacencyMatrix = new int[numVertices][numVertices];
	}

	/* Methode zum Kanten hinzufuegen */
	public void addEdge(int source, int destination) {
		adjacencyMatrix[source][destination] = 1;
		adjacencyMatrix[destination][source] = 1;
	}

	/* Methode zum gerichtete Kanten hinzufuegen */
	public void addDirectedEdge(int source, int destination) {
		adjacencyMatrix[source][destination] = 1;
	}

	/* Methode zum Ausgeben des Graphen auf der Konsole */
	public void printGraph() {
		/* Hier Code hinzufuegen */
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix.length; j++) {
				System.out.print(adjacencyMatrix[i][j] + " ");

			}
			System.out.println();
		}
	}

	/**** Main Methode - muss nicht veraendert werden ****/
//	public static void main(String[] args) {
//		final int numVertices = 5;
//		final Graph_Adjazenzmatrix graph = new Graph_Adjazenzmatrix(numVertices);
//
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 4);
//		graph.addEdge(1, 2);
//		graph.addEdge(1, 3);
//		graph.addEdge(1, 4);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 4);
//
//		graph.printGraph();
//
//	}

	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public boolean isVerbunden(int source, int destination) {
		return adjacencyMatrix[source][destination] == 1;
	}

	/**
	 * @param graph
	 * @param startknoten
	 * @return the distances to all nodes from the startnode.
	 */
//	public int[] breitensuche(int startknoten) {
//		final Queue<Integer> queue = new LinkedList<>();
//		final int[] predecessor = new int[numVertices];
//		final boolean besucht[] = new boolean[numVertices];
//		final int[] distances = new int[numVertices];
//
//		besucht[startknoten] = true;
//		predecessor[startknoten] = -1;
//		queue.add(startknoten);
//
//		while (!queue.isEmpty()) {
//			final int node = queue.remove();
////			System.out.println("Removing node " + node);
//
//			for (int otherNode = 0; otherNode < numVertices; otherNode++) {
//				if (isVerbunden(node, otherNode) && besucht[otherNode] == false) {
//					besucht[otherNode] = true;
//					predecessor[otherNode] = node;
//					distances[otherNode] = distances[node] + 1;
//					queue.add(otherNode);
////					System.out.println("Visiting node " + otherNode + ", setting its distance to "
////							+ distances[otherNode] + " and adding it to the queue");
//
//				}
//			}
//		}
////		System.out.println("predecessor: " + Arrays.toString(predecessor));
//		return distances;
//	}
}
