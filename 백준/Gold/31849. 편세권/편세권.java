import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			map[a - 1][b - 1] = p;
		}

		Queue<int[]> pq = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.add(new int[]{c - 1, d - 1, 0});
			visited[c - 1][d - 1] = true;
		}

		int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		int result = Integer.MAX_VALUE;
		int cnt = 0;
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			for (int d = 0; d < dir.length; d++) {
				int nx = tmp[0] + dir[d][0];
				int ny = tmp[1] + dir[d][1];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
					continue;
				}

				int distance = tmp[2] + 1;
				visited[nx][ny] = true;
				pq.add(new int[] {nx, ny, distance});

				if (map[nx][ny] != 0) { // 방이라면
					result = Math.min(result, distance * map[nx][ny]);
					cnt++;
				}
			}
			
			if (cnt == R) {
				break;
			}
		}

		System.out.println(result);
	}
}