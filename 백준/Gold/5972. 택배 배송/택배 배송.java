import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int node;
		int cnt;

		public Node(int node, int cnt) {
			this.node = node;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Node>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}

		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;

		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
		pq.add(new Node(1, 0));

		while (!pq.isEmpty()) {
			int cur = pq.poll().node;

			if (visited[cur]) {
				continue;
			}
			visited[cur] = true;

			for (Node next : list.get(cur)) {
				if (distance[next.node] > distance[cur] + next.cnt) {
					distance[next.node] = distance[cur] + next.cnt;
					pq.add(new Node(next.node, distance[next.node]));
				}
			}
		}

		System.out.println(distance[N]);
	}
}