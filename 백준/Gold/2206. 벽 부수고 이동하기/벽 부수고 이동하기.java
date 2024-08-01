import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		pq.add(new int[]{0, 0, 1, 0});
		int result = -1;
		boolean[][][] visited = new boolean[N][M][2];
		visited[0][0][0] = true;

		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();

			if (tmp[0] == N - 1 && tmp[1] == M - 1) {
				result = tmp[2];
				break;
			}

			for (int d = 0; d < dir.length; d++) {
				int nx = tmp[0] + dir[d][0];
				int ny = tmp[1] + dir[d][1];
				int cnt = tmp[2] + 1;
				int wallCnt = tmp[3];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][wallCnt]) {
					continue;
				}
				if (map[nx][ny] == 1 && wallCnt == 1) {
					continue;
				}

				if (map[nx][ny] == 1) {
					wallCnt = 1;
				}

				pq.add(new int[]{nx, ny, cnt, wallCnt});
				visited[nx][ny][wallCnt] = true;
			}
		}

		System.out.println(result);
	}
}