import java.util.LinkedList;
import java.util.Queue;

public class Breitensuchlauf {

	public static int[][] breitensuche(Graph_Adjazenzmatrix graph, int startknoten) {
		Queue<Integer> queue = new LinkedList<>();
		int n = graph.numVertices;
		int[] predecessor = new int[n];
		boolean besucht[] = new boolean[n];

		besucht[startknoten] = true;
		predecessor[startknoten] = -1;
		queue.add(startknoten);

		while (!queue.isEmpty()) {
			int u = queue.remove();
			for (int v = 0; v < n; v++) {
				if (besucht[v] == false) {
					besucht[v] = true;
					predecessor[v] = u;
					queue.add(v);
				}
			}
		}
		return ergebnis;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		int startknoten = 0;

		ergebnis = breitensuche(graph, startknoten);

	}

}
