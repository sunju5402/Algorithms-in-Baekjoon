import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static StringBuilder sb;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> list;
	static Set<String> set;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();
		arr = new int[M];
		visited = new boolean[N];
		list = new ArrayList<>();
		set = new HashSet<>();
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
			String str = "";
			for (int n : arr) {
				str += n + " ";
			}

			if (set.contains(str)) {
				return;
			}

			sb.append(str).append("\n");
			set.add(str);
			return;
		}

		for (int i = start; i < N; i++) {
			arr[depth] = list.get(i);
			permutation(i, depth + 1);
		}
	}
}