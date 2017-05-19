// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph

class ShortestPath {
	// A utility function to find the vertex with minimum distance value,
	// from the set of vertices not yet included in shortest path tree
	static final int V = 9;

	// A utility function to print the constructed distance array
	void printSolution(int dist[], int n) {
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	void dijkstra(int graph[][], int src) {
		int dist[] = new int[V];
		boolean sptSet[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;

		for (int c = 0; c < V - 1; c++) {
			int u = minDist(dist, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < V; v++) {
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
						&& (graph[u][v] + dist[u] < dist[v])) {
					dist[v] = graph[u][v] + dist[u];
				}
			}
		}

		printSolution(dist, V);
	}

	private int minDist(int[] dist, boolean[] sptSet) {
		int min = Integer.MAX_VALUE;
		int min_idx = -1;
		for (int v = 0; v < V; v++) {
			if (!sptSet[v] && dist[v] <= min) {
				min = dist[v];
				min_idx = v;
			}
		}
		return min_idx;
	}

	// Driver method
	public static void main(String[] args) {
		/* Let us create the example graph discussed above */
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		ShortestPath t = new ShortestPath();
		t.dijkstra(graph, 0);
	}
}
