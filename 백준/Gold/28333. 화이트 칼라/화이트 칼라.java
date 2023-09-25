import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static ArrayList<ArrayList<Integer>> list;
	static ArrayList<ArrayList<Integer>> road;
	static ArrayList<Integer> result;
	static HashSet<Integer> set;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();
			road = new ArrayList<>();
			result = new ArrayList<>();
			set = new HashSet<>();
			for (int j = 0; j <= N; j++) {
				list.add(new ArrayList<>());
				road.add(new ArrayList<>());
			}

			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				list.get(a).add(b);
			}

			bfs();
			reverseBfs();

			Collections.sort(result);
			for (int j = 0; j < result.size(); j++) {
				sb.append(result.get(j)).append(" ");
			}
			sb.append(N).append("\n");
		}

		System.out.print(sb.toString());
	}

	private static void bfs() {
		dist = new int[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		dist[1] = 1;
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list.get(now)) {
				int cnt = dist[now] + 1;
				if (dist[next] == 0) {
					dist[next] = cnt;
					q.add(next);
					road.get(next).add(now);
				} else if (dist[next] == cnt) {
					road.get(next).add(now);
				}
			}
		}
	}

	private static void reverseBfs() {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(N);
		visited[N] = true;
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : road.get(now)) {
				if (!visited[next]) {
					result.add(next);
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
}