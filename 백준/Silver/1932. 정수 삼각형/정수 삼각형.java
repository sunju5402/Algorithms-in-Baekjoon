import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr, dp;
	static int N;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			dp[N - 1][i] = arr[N - 1][i];
		}

		System.out.println(dfs(0, 0));
	}

	static int dfs(int depth, int idx) {
		if (depth == N - 1) {
			return dp[depth][idx];
		}

		if (dp[depth][idx] == 0) {
			dp[depth][idx] = Math.max(dfs(depth + 1, idx), dfs(depth + 1, idx + 1)) + arr[depth][idx];
		}

		return dp[depth][idx];
	}
}