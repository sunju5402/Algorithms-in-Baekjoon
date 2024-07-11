import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int[] tmp = new int[M];
		for (int i = 0; i < M; i++) {
			tmp[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 0) {
					arr[i][j] = tmp[j];
				}
			}
		}

		int[] tmp2 = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			tmp2[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = Math.min(arr[i][j], tmp2[N - i - 1]);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		boolean checked = false;
		for (int i = 0; i < M; i++) {
			int n = 0;
			for (int j = 0; j < N; j++) {
				n = Math.max(n, arr[j][i]);
			}
			if (n != tmp[i]) {
				checked = true;
				break;
			}
		}

		if (!checked) {
			for (int i = 0; i < N; i++) {
				int n = 0;
				for (int j = 0; j < M; j++) {
					n = Math.max(n, arr[i][j]);
				}

				if (n != tmp2[N - i - 1]) {
					checked = true;
					break;
				}
			}
		}

		if (checked) {
			System.out.println(-1);
		} else {
			System.out.print(sb.toString());
		}
	}
}