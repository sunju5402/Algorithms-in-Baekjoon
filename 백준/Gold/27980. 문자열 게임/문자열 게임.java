import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static String str1, str2;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		str1 = br.readLine();
		str2 = br.readLine();
		dp = new int[N][M];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dfs(0, i));
		}

		System.out.println(answer);
	}

	private static int dfs(int depth, int idx) {
		if (depth == M) {
			return 0;
		}

		if (idx < 0 || idx >= N) {
			return 0;
		}

		if (dp[idx][depth] != -1) {
			return dp[idx][depth];
		}

		int result = 0;

		if (str1.charAt(idx) == str2.charAt(depth)) {
			result = 1 + Math.max(dfs(depth + 1, idx + 1), dfs(depth + 1, idx - 1));
		} else {
			result = Math.max(dfs(depth + 1, idx + 1), dfs(depth + 1, idx - 1));
		}

		return dp[idx][depth] = result;
	}
}