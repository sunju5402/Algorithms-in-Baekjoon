import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<List<Integer>> list = new ArrayList<>();
		int[] arr = new int[N + 1];
		int[] result = new int[N];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			arr[b]++;
		}

		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				q.add(new int[]{i, 1});
				visited[i] = true;
			}
		}

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			result[tmp[0] - 1] = tmp[1];

			for (int n : list.get(tmp[0])) {
				arr[n]--;
				if (!visited[n] && arr[n] == 0) {
					q.add(new int[]{n, tmp[1] + 1});
					visited[n] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}