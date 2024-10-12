import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] num;
	static StringBuilder sb;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[M];
		sb = new StringBuilder();

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

		for (int i = 1; i <= N; i++) {
			num[depth] = i;
			solve(depth + 1);
		}
	}
}
