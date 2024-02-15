import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[] visited;
	static List<List<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
            list.get(b).add(a);
		}

		visited = new boolean[N + 1];
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				result++;
			}
		}

		System.out.println(result);
	}

	private static void dfs(int n) {
		visited[n] = true;
		for (int i = 0; i < list.get(n).size(); i++) {
			if (!visited[list.get(n).get(i)]) {
				dfs(list.get(n).get(i));
			}
		}
	}
}