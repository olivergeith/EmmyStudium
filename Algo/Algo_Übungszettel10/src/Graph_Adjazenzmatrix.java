public class Graph_Adjazenzmatrix {
    private int numVertices;
    private int[][] adjacencyMatrix;

    /*Klassen Konstruktor*/
    public Graph_Adjazenzmatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
    }

    /*Methode zum Kanten hinzufuegen*/
    public void addEdge(int source, int destination) {
    	/*Hier Code hinzufuegen*/
    }

    /*Methode zum Ausgeben des Graphen auf der Konsole*/
    public void printGraph() {
    	/*Hier Code hinzufuegen*/
    }

    /****Main Methode - muss nicht veraendert werden****/
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
}
