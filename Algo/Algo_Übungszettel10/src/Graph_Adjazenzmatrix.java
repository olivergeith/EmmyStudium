public class Graph_Adjazenzmatrix {
	int numVertices;
	private int[][] adjacencyMatrix;

	/* Klassen Konstruktor */
	public Graph_Adjazenzmatrix(int numVertices) {
		this.numVertices = numVertices;
		this.adjacencyMatrix = new int[numVertices][numVertices];
	}

	/* Methode zum Kanten hinzufuegen */
	public void addEdge(int source, int destination) {
		adjacencyMatrix[source][destination] = 1;
		adjacencyMatrix[destination][source] = 1;
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
	public static void main(String[] args) {
		int numVertices = 5;
		Graph_Adjazenzmatrix graph = new Graph_Adjazenzmatrix(numVertices);

		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		graph.printGraph();
	}

	public int[][] getAdjacencyMatrix() {
		// TODO Auto-generated method stub
		return adjacencyMatrix;
	}
}
