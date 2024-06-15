import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int[][] rowSum = new int[N][N]; // 가로

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (j > 0) {
					rowSum[i][j] = rowSum[i][j - 1] + map[i][j];
				} else {
					rowSum[i][j] = map[i][j];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;

			int total = 0;
			for (int j = x1; j <= x2; j++) {
				if (y1 - 1 < 0) {
					total += rowSum[j][y2];
				} else {
					total += rowSum[j][y2] - rowSum[j][y1 - 1];
				}
			}
			sb.append(total).append("\n");
		}

		System.out.print(sb.toString());
	}
}