import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] num;
	static StringBuilder sb;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[M];
		sb = new StringBuilder();
		list = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);

		solve(0);

		System.out.print(sb.toString());
	}

	private static void solve(int depth) {
		if (depth == M) {
			for (int n : num) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			num[depth] = list.get(i);
			solve(depth + 1);
		}
	}
}