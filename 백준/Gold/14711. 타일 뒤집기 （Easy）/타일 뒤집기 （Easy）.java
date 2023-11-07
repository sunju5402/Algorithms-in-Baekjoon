import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] cur = new int[N + 2];
		int[] pre = new int[N + 2];

		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		sb.append(s).append("\n");

		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == '#') cur[i + 1] = 1;
		}

		int cnt;
		for (int i = 1; i < N; i++) {
			s = "";
			for (int j = 1; j <= N; j++) {
				cnt = 0;

				if (pre[j] == 1) cnt++;
				if (cur[j - 1] == 1) cnt++;
				if (cur[j + 1] == 1) cnt++;

				if (cnt % 2 == 0) {
					s += ".";
				}
				else {
					s += "#";
				}
			}

			sb.append(s).append("\n");

			for (int j = 1; j <= N; j++) {
				pre[j] = cur[j];
				if (s.charAt(j - 1) == '.') cur[j] = 0;
				else cur[j] = 1;
 			}
		}

		System.out.print(sb.toString());
	}
}