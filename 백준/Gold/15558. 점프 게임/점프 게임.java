import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];

		for (int i = 0; i < 2; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				arr[j][i] = s.charAt(j) - '0';
			}
		}

		int result = 0;
		boolean[][] visited = new boolean[N][2];
		int[][] dir = {{1, 0}, {-1, 0}, {k, 1}, {k, -1}};
		Queue<int[]> q = new ArrayDeque<>();

		q.add(new int[]{0, 0, 0});
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < dir.length; d++) {
				int nx = cur[0] + dir[d][0];
				int ny = cur[1] + dir[d][1];

				// 범위를 벗어나거나 사라지는 칸으로 움직일 경우
				if (ny >= 2 || ny < 0 || nx < 0 || nx <= cur[2]) continue;
				if (nx >= N) { // 게임을 클리어할 수 있으면
					result = 1;
					break;
				} else if (visited[nx][ny] || arr[nx][ny] == 0) { // 위험한 곳이면
					continue;
				}

				visited[nx][ny] = true;
				q.add(new int[]{nx, ny, cur[2] + 1});
			}

			if (result == 1) break; // 게임을 클리어 했으면
		}

		System.out.println(result);
	}
}