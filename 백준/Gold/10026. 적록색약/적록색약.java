import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static char[][] arr;
	static char[][] copyArr;
	static HashMap<Character, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		arr = new char[N][N];
		copyArr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
				copyArr[i][j] = s.charAt(j);
			}
		}

		map.put('R', 0);
		map.put('G', 0);
		map.put('B', 0);
		map.put('Y', 0); // 적록

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != '.') {
					map.put(arr[i][j], map.get(arr[i][j]) + 1);
					dfs1(i, j, arr[i][j]);
				}
				if (copyArr[i][j] != '.') {
					if (copyArr[i][j] == 'R' || copyArr[i][j] == 'G') {
						map.put('Y', map.get('Y') + 1);
						dfs2(i, j);
					}
				}
			}
		}

		int a = map.get('R') + map.get('G') + map.get('B');
		int b = map.get('Y') + map.get('B');
		System.out.println(a + " " + b);
	}

	private static void dfs1(int r, int c, char ch) {
		if (r < 0 || r >= N || c < 0 || c >= N) return;

		if (arr[r][c] == ch) {
			arr[r][c] = '.';
			dfs1(r - 1, c, ch);
			dfs1(r + 1, c, ch);
			dfs1(r, c - 1, ch);
			dfs1(r, c + 1, ch);
		}
	}

	private static void dfs2(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) return;

		if (copyArr[r][c] == 'R' || copyArr[r][c] == 'G') { // 적록일경우
			copyArr[r][c] = '.';
			dfs2(r - 1, c);
			dfs2(r + 1, c);
			dfs2(r, c - 1);
			dfs2(r, c + 1);
		}
	}
}