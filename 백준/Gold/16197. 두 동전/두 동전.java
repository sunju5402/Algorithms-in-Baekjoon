import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static char[][] map;
	static int[] coins;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		coins = new int[4];
		for (int i = 0, k = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'o') {
					coins[k++] = i;
					coins[k++] = j;
				}
			}
		}

		int result = bfs();
		System.out.println(result);
	}

	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{coins[0], coins[1], coins[2], coins[3], 0});
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		boolean visited[][][][] = new boolean[N][M][N][M];
		visited[coins[0]][coins[1]][coins[2]][coins[3]] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int out = 0;
				int nx1 = tmp[0] + dir[i][0];
				int ny1 = tmp[1] + dir[i][1];
				int nx2 = tmp[2] + dir[i][0];
				int ny2 = tmp[3] + dir[i][1];
				int cnt = tmp[4] + 1;

				if (cnt > 10) {
					return -1;
				}

				if (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M) {
					out++;
				} else {
					if (map[nx1][ny1] == '#') {
						nx1 = tmp[0];
						ny1 = tmp[1];
					}
				}

				if (nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M) {
					out++;
				} else {
					if (map[nx2][ny2] == '#') {
						nx2 = tmp[2];
						ny2 = tmp[3];
					}
				}

				if (out == 2) {
					continue;
				} else if (out == 1) {
					return cnt;
				} else {
					if (visited[nx1][ny1][nx2][ny2]) continue;

					visited[nx1][ny1][nx2][ny2] = true;
					q.add(new int[]{nx1, ny1, nx2, ny2, cnt});
				}
			}
		}

		return -1;
	}
}