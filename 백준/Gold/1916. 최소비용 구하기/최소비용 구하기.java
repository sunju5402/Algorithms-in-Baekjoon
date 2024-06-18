import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int idx;
		int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost ,o.cost);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st;
		ArrayList<ArrayList<Node>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, v));
		}

		st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;

		boolean[] visited = new boolean[N + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();

			if (visited[current.idx]) {
				continue;
			}
			
			visited[current.idx] = true;

			for (Node next : list.get(current.idx)) {
				if (dist[next.idx] > dist[current.idx] + next.cost) {
					dist[next.idx] = dist[current.idx] + next.cost;

					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}

		System.out.println(dist[d]);

	}
}