import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[][] map;
	static int[][] dir = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};
	static int[][] cDir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 소의 위치를 체크하기 위한 방향 배열
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] cow = new int[K][2];

		int size = N + N;
		map = new int[size][size];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			map[r + r2 - 1][c + c2 - 1] = 1;
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[r + r - 1][c + c - 1] = 2;
			cow[i][0] = r * 2 - 1;
			cow[i][1] = c * 2 - 1;
		}

		for (int i = 0; i < K - 1; i++) {
			result += K - i - 1 - bfs(cow[i][0], cow[i][1], new boolean[size][size]);
		}

		System.out.println(result);
	}

	private static int bfs(int i, int j, boolean[][] visited) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{i, j});

		visited[i][j] = true;
		map[i][j] = 0;

		int cnt = 0; // 길을 안 건너도 만날 수 있는 소의 개수
		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now[0] + dir[d][0];
				int ny = now[1] + dir[d][1];

				if (nx < 0 || nx >= N * 2 || ny < 0 || ny >= N * 2 || visited[nx][ny]) continue;

				if (map[nx][ny] == 1 || map[nx - cDir[d][0]][ny - cDir[d][1]] == 1) { // 길이면
					continue;
				} else if (map[nx][ny] == 2) { // 소의 위치면
					cnt++;
				}
				visited[nx][ny] = true;
				q.add(new int[]{nx, ny});
			}
		}
		return cnt;
	}
}