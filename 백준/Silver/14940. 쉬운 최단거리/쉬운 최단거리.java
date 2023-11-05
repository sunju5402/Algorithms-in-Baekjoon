import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		int[] destination = new int[2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					destination[0] = i;
					destination[1] = j;
					map[i][j] = 0;
				}
			}
		}

		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> q = new ArrayDeque<>();

		q.add(new int[]{destination[0], destination[1]});
		visited[destination[0]][destination[1]] = true;

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dir[d][0];
				int ny = cur[1] + dir[d][1];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]
				|| map[nx][ny] == 0) continue;

				map[nx][ny] = map[cur[0]][cur[1]] + 1;

				q.add(new int[]{nx, ny});
				visited[nx][ny] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					sb.append(-1).append(" ");
				} else {
					sb.append(map[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}