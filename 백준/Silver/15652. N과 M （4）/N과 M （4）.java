import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static StringBuilder sb;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		sb = new StringBuilder();

		solve(1, 0);
		System.out.print(sb.toString());
	}

	private static void solve(int start, int depth) {
		if (depth == M) {
			for (int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			solve(i, depth + 1);
		}
	}
}