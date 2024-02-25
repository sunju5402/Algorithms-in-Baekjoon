import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] hi = new int[N];
		int[] arc = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hi[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arc[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(hi);
		Arrays.sort(arc);

		long[] result = new long[3];
		int idx = 0;
		int[] sameCnt = new int[Math.max(hi[N - 1], arc[M - 1]) + 1];
		for (int i = 0; i < M; i++) {
			while (idx < N && hi[idx] <= arc[i]) {
				if (hi[idx] == arc[i]) {
					sameCnt[arc[i]]++;
				}
				idx++;
			}

			result[0] += (N - idx);
			result[1] += (idx - sameCnt[arc[i]]);
			result[2] += sameCnt[arc[i]];
		}

		System.out.print(result[0] + " " + result[1] + " " + result[2]);
	}
}