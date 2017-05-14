import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 크루스칼 알고리즘은 쉽게 설명하면 다음과 같다. 

1. 모든 edge를 가중치 별로 정렬한다. 

방향성을 가지지 않기 때문에 입력받은 map에서 중복되지 않는 edge만을 points 배열에 저장하였다. 

정렬은 Java내의 정렬을 사용해도 되나 quick sort를 구현해보았다. 

2. 가장 작은 가중치를 가진 edge을 선택한다. 

3. 선택한 edge가 cycle을 만들면 그 edge는 버린다. 

이때 구현을 위해 각각의 점에 label을 붙였고, 연결된 vertex끼리는 같은 label을 가져가도록 하였다. 

모든 vertex가 동일한 label을 가지고 있다면 모든 vertex는 연결된 것이다. 

4. 2, 3번을 반복하며 N개의 vertex가 있을 때 N-1개의 edge가 선택되면 알고리즘이 종료된다. (N개의 vertex는 N-1개의 edge로 연결이 가능하다.)

 */

public class MST {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] label = new int[N];
		List<Vertex> vList = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			label[i] = i;
			for (int j = 0; j < N; ++j) {
				int weight = sc.nextInt();
				if (i < j) {
					vList.add(new Vertex(i, j, weight));
				}
			}
		}
		Vertex[] points = vList.toArray(new Vertex[0]);

		// 1. 정렬
		Arrays.sort(points);

		// 2. 어사이클
		int nodes = 0, index = 0;
		int cost = 0;
		while (nodes < N - 1) { // 선의 개수는 주어진 점보다 1개 작다.

			Vertex point = points[index];

			if (label[point.x] != label[point.y]) {

				int tmp = label[point.y]; // last dst 기준의 label ?

				for (int i = 0; i < N; ++i) { //
					if (tmp == label[i])
						label[i] = label[point.x];
				}
				cost += point.cost;
				nodes++;
			}
			index++;
		}

		System.out.println(cost);
	}

	public static void quickSort(Vertex[] array, int s, int e) {
		if (s >= e) {
			return;
		}
		int i = s + 1;
		int j = e;
		Vertex pivot = array[s];

		while (i <= j) {
			while (i <= e && array[i].cost <= pivot.cost)
				i++;
			while (s + 1 <= j && pivot.cost <= array[j].cost)
				j--;

			if (i <= j) {
				Vertex temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			} else {
				array[s] = array[j];
				array[j] = pivot;
			}
		}
		quickSort(array, s, j - 1);
		quickSort(array, j + 1, e);
	}
}

class Vertex implements Comparable<Vertex> {
	public int x;
	public int y;
	public int cost;

	Vertex(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	public int compareTo(Vertex o) {
		return this.cost - o.cost;

	}

}
