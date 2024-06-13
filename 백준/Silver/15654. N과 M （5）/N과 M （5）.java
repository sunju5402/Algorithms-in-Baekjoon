import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static StringBuilder sb;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();
		arr = new int[M];
		visited = new boolean[N];
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);

		permutation(0, 0);
		System.out.print(sb.toString());
	}

	private static void permutation(int start, int depth) {
		if (depth == M) {
			for (int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = list.get(i);
				permutation(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
}