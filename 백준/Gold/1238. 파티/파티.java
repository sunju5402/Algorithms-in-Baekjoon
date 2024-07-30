import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int node;
		int weight;

		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<List<Node>> list = new ArrayList<>();
		List<List<Node>> reverseList = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			reverseList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, v));
			reverseList.get(b).add(new Node(a, v));
		}

		int[] distance = new int[N + 1];
		int[] reverseDistance = new int[N + 1];
		int result = 0;

		solve(X, list, distance);
		solve(X, reverseList, reverseDistance);

		for (int i = 1; i <= N; i++) {
			result = Math.max(result, distance[i] + reverseDistance[i]);
		}

		System.out.println(result);
	}

	private static void solve(int x, List<List<Node>> list, int[] distance) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[x] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		pq.add(new Node(x, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (Node next : list.get(cur.node)) {
				if (distance[cur.node] + next.weight < distance[next.node]) {
					distance[next.node] = cur.weight + next.weight;
					pq.add(new Node(next.node, cur.weight + next.weight));
				}
			}
		}
	}
}