import java.io.*;

public class Main {
	static int N;
	static long[][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		memo = new long[31][31];

		StringBuilder sb = new StringBuilder();
		while (N != 0) {
			sb.append(solve(N, 0)).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		System.out.print(sb.toString());
	}

	private static long solve(int wCnt, int hCnt) {
		if (wCnt == 0 && hCnt == 0) {
			return 1;
		}

		if (memo[wCnt][hCnt] != 0) return memo[wCnt][hCnt];

		long result = 0;
		if (wCnt > 0) {
			result += solve(wCnt - 1, hCnt + 1);
		}
		if (hCnt > 0) {
			result += solve(wCnt, hCnt - 1);
		}

		return memo[wCnt][hCnt] = result;
	}
}