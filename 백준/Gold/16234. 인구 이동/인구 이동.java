import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		Queue<int[]> q;
		boolean[][] visited;
		List<int[]> list;
		int result = 0;

		while (true) {
			boolean moved = false;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						list = new ArrayList<>();
						q = new ArrayDeque<>();

						q.add(new int[]{i, j});
						list.add(new int[]{i, j});
						visited[i][j] = true;

						int sum = arr[i][j];

						while (!q.isEmpty()) {
							int[] tmp = q.poll();

							for (int d = 0; d < dir.length; d++) {
								int nx = tmp[0] + dir[d][0];
								int ny = tmp[1] + dir[d][1];

								if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
									continue;
								}

								int diff = Math.abs(arr[tmp[0]][tmp[1]] - arr[nx][ny]);
								if (diff >= L && diff <= R) {
									q.add(new int[]{nx, ny});
									list.add(new int[]{nx, ny});
									visited[nx][ny] = true;
									sum += arr[nx][ny];
								}
							}
						}

						if (list.size() > 1) {
							int val = sum / list.size();

							for (int k = 0; k < list.size(); k++) {
								int[] tmp = list.get(k);
								arr[tmp[0]][tmp[1]] = val;
							}
							moved = true;
						}
					}
				}
			}

			if (!moved) {
				break;
			} else {
				result++;
			}
		}

		System.out.println(result);
	}
}