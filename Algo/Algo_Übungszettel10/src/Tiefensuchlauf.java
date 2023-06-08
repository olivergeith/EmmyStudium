import java.util.ArrayList;
import java.util.Stack;

public class Tiefensuchlauf {
	public static ArrayList<Integer> depthFirstsSearch(int s, Graph_Adjazenzmatrix graph) {
		ArrayList<Integer> reihenfolge = new ArrayList<Integer>();
		final int anzahlNodes = graph.numVertices;
		final boolean besucht[] = new boolean[anzahlNodes];
		Stack<Integer> stack = new Stack<Integer>();

		besucht[s] = true;
		stack.push(s);
		reihenfolge.add(s);
		while (!stack.isEmpty()) {
			final int o = stack.pop();
			for (int n = 0; n < anzahlNodes; n++) {
				if (!besucht[n] && graph.isVerbunden(o, n)) {
					besucht[n] = true;
					reihenfolge.add(n);
					stack.push(n);
				}
			}
		}

		return reihenfolge;
	}

	public static void main(String[] args) {
		final int numVertices = 5;
		final Graph_Adjazenzmatrix graph = new Graph_Adjazenzmatrix(numVertices);

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(0, 4);

//		graph.addEdge(0, 1);
//		graph.addEdge(0, 4);
//		graph.addEdge(1, 2);
//		graph.addEdge(1, 3);
//		graph.addEdge(1, 4);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 4);

		graph.printGraph();

		final int startknoten = 0;

		ArrayList<Integer> reihenfolge = depthFirstsSearch(startknoten, graph);

		for (int i = 0; i < numVertices; i++) {
			System.out.println(reihenfolge.get(i));
		}
	}

}
