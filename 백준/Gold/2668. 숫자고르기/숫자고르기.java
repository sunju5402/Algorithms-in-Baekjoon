import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int[] arr;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		list = new ArrayList<>();
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, i + 1);
			visited[i] = false;
		}

		Collections.sort(list);

		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void dfs(int start, int target) {
		if (!visited[arr[start] - 1]) {
			visited[arr[start] - 1] = true;
			dfs(arr[start] - 1, target);
			visited[arr[start] - 1] = false;
		}

		if (arr[start] == target) {
			list.add(target);
		}
	}
}