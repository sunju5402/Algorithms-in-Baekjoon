import java.io.*;
import java.util.*;

public class Main {

	static int L, N;
	static boolean[] selected;
	static int[] comb;
	static char[][] map;
	static String[] words;
	static boolean result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken()); // 길이
		N = Integer.parseInt(st.nextToken()); // 단어 개수

		map = new char[L][L]; // 마방진
		selected = new boolean[N];
		comb = new int[L];
		words = new String[N];

		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}

		Arrays.sort(words);

		dfs(0);
		if (!result) {
			System.out.println("NONE");
		}
	}

	private static void dfs(int cnt) {
		if (result) {
			return;
		}

		if (cnt == L) {
			for (int i = 0; i < L; i++) {
				map[i] = words[comb[i]].toCharArray();
			}

			// 마방진 체크
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < L; j++) {
					if (map[i][j] != map[j][i]) {
						return;
					}
				}
			}

			for (int i = 0; i < L; i++) {
				System.out.println(map[i]);
			}
			result = true;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				comb[cnt] = i;
				dfs(cnt + 1);
				selected[i] = false;
			}
		}
	}
}