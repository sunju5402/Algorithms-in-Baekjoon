import java.io.*;

public class Main {
	static boolean[][] memo;
	static char[][] arr;
	static int N;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String st = "";
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][4];
			memo = new boolean[N][7];
			for (int j = 0; j < N; j++) {
				st = br.readLine().replace(" ", "");
				arr[j] = st.toCharArray();
			}

			flag = false;
			solve(0, 1);
			if (flag) {
				sb.append("LUCKY");
			} else {
				sb.append("UNLUCKY");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}

	private static void solve(int depth, int num) {
		if (depth == N) {
			if (num == 0) {
				flag = true;
			}
			return;
		}

		if (memo[depth][num] || flag) {
			return;
		}

		memo[depth][num] = true;

		if (arr[depth][0] == '+') {
			solve(depth + 1, (num + (arr[depth][1] - '0')) % 7);
		} else {
			solve(depth + 1, (num * (arr[depth][1] - '0')) % 7);
		}

		if (arr[depth][2] == '+') {
			solve(depth + 1, (num + (arr[depth][3] - '0')) % 7);
		} else {
			solve(depth + 1, (num * (arr[depth][3] - '0')) % 7);
		}
	}
}