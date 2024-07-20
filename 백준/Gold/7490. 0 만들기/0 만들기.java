import java.io.*;

public class Main {
	static StringBuilder sb;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			dfs(1, 1, 1, 0,  "1");
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}

	private static void dfs(int n, int op, int depth, int total, String s) {
		if (depth == N) {
			total += n * op;

			if (total == 0) {
				sb.append(s).append("\n");
			}
			return;
		}

		dfs(n * 10 + depth + 1, op, depth + 1, total, s + " " + (depth + 1));
		dfs(depth + 1, 1, depth + 1,  total + n * op, s + "+" + (depth + 1));
		dfs(depth + 1, -1, depth + 1, total + n * op, s + "-" + (depth + 1));
	}
}