import java.io.*;

public class Main {
	static int[][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		memo = new int[2][41];
		memo[0][0] = 1;
		memo[1][0] = 0;
		memo[0][1] = 0;
		memo[1][1] = 1;

		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			for (int j = 2; j <= num; j++) {
				memo[0][j] = memo[0][j - 1]  + memo[0][j - 2];
				memo[1][j] = memo[1][j - 1]  + memo[1][j - 2];
			}
			sb.append(memo[0][num]).append(" ").append(memo[1][num]).append("\n");
		}

		System.out.print(sb.toString());
	}
}
