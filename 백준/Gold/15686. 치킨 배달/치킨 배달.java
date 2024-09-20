import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> house, chicken;
	static int N, M, result;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		house = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) {
					house.add((i * N + j + 1));
				} else if (n == 2) {
					chicken.add(i * N + j + 1);
				}
			}
		}

		result = Integer.MAX_VALUE;
		visited = new boolean[chicken.size()];

		dfs(0, 0);

		System.out.println(result);
	}

	static private void dfs(int depth, int idx) {
		if (depth == M) {
			int sum = 0;
			for (int i = 0; i < house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					min = Math.min(min, Math.abs((house.get(i) - 1) / N - (chicken.get(arr[j]) - 1) / N) +
						Math.abs((house.get(i) - 1) % N + 1 - ((chicken.get(arr[j]) - 1) % N + 1)));
				}

				sum += min;
			}

			result = Math.min(result, sum);

			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				dfs(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}