import java.io.*;
import java.util.*;

public class Main {

	static class Node {

		int node;
		int distance;

		public Node() {
		}

		public Node(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] friendLoc = new int[3];
		for (int i = 0; i < 3; i++) {
			friendLoc[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int D = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			list.get(D).add(new Node(E, L));
			list.get(E).add(new Node(D, L));
		}

		int result = 0;
		int far = Integer.MIN_VALUE;
		PriorityQueue<Node> pq = new PriorityQueue<>(
			((o1, o2) -> Integer.compare(o1.distance, o2.distance)));

		int[][] distance = new int[3][N + 1];
		for (int i = 0; i < 3; i++) { // 출발점을 달리 하면서
			Arrays.fill(distance[i], Integer.MAX_VALUE);
			distance[i][friendLoc[i]] = 0;

			pq.add(new Node(friendLoc[i], 0));

			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				for (Node next : list.get(cur.node)) {
					if (distance[i][next.node] > distance[i][cur.node] + next.distance) {
						distance[i][next.node] = distance[i][cur.node] + next.distance;
						pq.add(new Node(next.node, distance[i][next.node]));
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			int tmp = Integer.MAX_VALUE;
			for (int j = 0; j < 3; j++) {
				if (tmp > distance[j][i]) {
					tmp = distance[j][i];
				}
			}
			
			if (far < tmp) {
				result = i;
				far = tmp;
			}
		}

		System.out.println(result);
	}
}