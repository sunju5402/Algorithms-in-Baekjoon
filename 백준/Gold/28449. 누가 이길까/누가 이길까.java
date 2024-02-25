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
		if (N > M) { // arc팀 참가자가 적을 경우
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
		} else { // hi 팀 참가자가 적을 경우
			for (int i = 0; i < N; i++) {
				while (idx < M && hi[i] >= arc[idx]) {
					if (hi[i] == arc[idx]) {
						sameCnt[hi[i]]++;
					}
					idx++;
				}

				result[0] += (idx - sameCnt[hi[i]]);
				result[1] += (M - idx);
				result[2] += sameCnt[hi[i]];
			}
		}

		System.out.print(result[0] + " " + result[1] + " " + result[2]);
	}
}