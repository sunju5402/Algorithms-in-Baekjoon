import java.io.*;
import java.util.*;

public class Main {
	static List<String> list;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			dfs(1, 1, "1");

			Collections.sort(list);

			for (String s : list) {
				sb.append(s).append("\n");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}

	private static void dfs(int n, int depth, String s) {
		if (depth == N) {
			int total = 0;
			StringBuilder tmp = new StringBuilder();
			String ss = s.replace(" ", "");
			char c = '+';
			for (int i = 0; i < ss.length(); i++) {
				if (ss.charAt(i) == '+') {
					if (c == '+') {
						total += Integer.parseInt(tmp.toString());
					} else {
						total -= Integer.parseInt(tmp.toString());
					}
					c = '+';
					tmp = new StringBuilder();
				} else if (ss.charAt(i) == '-') {
					if (c == '+') {
						total += Integer.parseInt(tmp.toString());
					} else {
						total -= Integer.parseInt(tmp.toString());
					}
					c = '-';
					tmp = new StringBuilder();
				} else {
					tmp.append(ss.charAt(i));
				}
			}

			if (c == '+') {
				total += Integer.parseInt(tmp.toString());
			} else {
				total -= Integer.parseInt(tmp.toString());
			}

			if (total == 0) {
				list.add(s);
			}
			return;
		}

		dfs(n + 1, depth + 1, s + "+" + (n + 1));
		dfs(n + 1, depth + 1, s + "-" + (n + 1));
		dfs(n + 1, depth + 1, s + " " + (n + 1));
	}
}