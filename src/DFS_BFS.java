
import java.util.ArrayList;

public class DFS_BFS {

	/*
	 * 인접 행렬을 이용한 그래프 표현 무방향 그래프에서 인접행렬은 대칭(symmetric)이다.
	 */
	static int[][] graph = { { 0, 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1, 1, 0, 0, 0 },
			{ 1, 0, 0, 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0, 0, 0, 1, 0 },
			{ 0, 1, 1, 1, 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 1, 1, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0 } };
	static int n = graph.length;
	static boolean[] visited = new boolean[n];

	// 깊이우선 탐색
	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int i = 0; i < n; i++)
			if (graph[v][i] == 1 && !visited[i])
				dfs(i);
	}

	// 너비우선탐색
	static void bfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		Queue q = new Queue(v);
		while (true) {
			for (int i = 0; i < n; i++) {
				if (graph[v][i] == 1 && !visited[i]) {
					q.add(new Integer(i));
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
			q.delete(new Integer(v));
			if (q.isEmpty())
				break;
			v = ((Integer) q.getFirst()).intValue();
		}
	}

	public static void main(String[] args) {
		// 깊이우선 탐색 출력
		System.out.print("DFS ");
		dfs(0);
		System.out.println();
		clearVisited();
		// 너비우선 탐색 출력
		System.out.print("BFS ");
		bfs(0);
		System.out.println();
		clearVisited();
	}

	static void clearVisited() {
		for (int i = 0; i < n; i++)
			visited[i] = false;
	}
}

class Queue {
	ArrayList list = new ArrayList();

	public Queue(int i) {
		add(new Integer(i));
	}

	void add(Object o) {
		list.add(o);
	}

	void delete(Object o) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(o)) {
				list.remove(i);
				break;
			}
		}
	}

	boolean isEmpty() {
		return list.isEmpty();
	}

	Object getFirst() {
		return list.get(0);
	}
}