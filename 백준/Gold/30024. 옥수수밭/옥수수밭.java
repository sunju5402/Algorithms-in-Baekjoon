import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        
		int[][] corns = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[2], o1[2]));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int price = Integer.parseInt(st.nextToken());
				corns[i][j] = price;
				if (i == 0 || i == N - 1 || j == 0 || j == M - 1) { // 가장자리에 있는 옥수수의 가치를 저장하기 위함.
					pq.add(new int[]{i, j, price});
					visited[i][j] = true;
				}
			}
		}

		int K = Integer.parseInt(br.readLine()); // 수확할 옥수수 개수

		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		StringBuilder sb = new StringBuilder();
		int cnt = 0; // 수확한 옥수수 개수
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			sb.append(cur[0] + 1).append(" ").append(cur[1] + 1).append("\n");
			cnt++;
			if (cnt == K) break;
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dir[d][0];
				int ny = cur[1] + dir[d][1];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

				pq.add(new int[]{nx, ny, corns[nx][ny]});
				visited[nx][ny] = true;
			}
		}

		System.out.print(sb.toString());
	}
}