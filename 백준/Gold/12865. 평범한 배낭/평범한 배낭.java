import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			list.add(new int[]{W, V});
		}

		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (list.get(i - 1)[0] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - list.get(i - 1)[0]] + list.get(i - 1)[1]);
				}
			}
		}

		System.out.println(dp[N][K]);
	}
}