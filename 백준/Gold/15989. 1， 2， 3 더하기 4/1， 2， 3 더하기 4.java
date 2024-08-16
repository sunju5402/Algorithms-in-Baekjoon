import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[10001];
		dp[0] = 1;
		for (int i = 1; i <= 3; i++) {
			for (int j = 10000; j >= 1; j--) {
				for (int k = 1; j - i * k >= 0; k++) {
					dp[j] += dp[j - i * k];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}