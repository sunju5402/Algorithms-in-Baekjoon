import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 나무의 개수
		int Q = Integer.parseInt(st.nextToken()); // 찍은 사진의 개수

		int[] treeLoc = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			treeLoc[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(treeLoc);
		long[] sum = new long[N];
		sum[0] = treeLoc[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + treeLoc[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			long photoLoc = Long.parseLong(br.readLine());
			int left = 0;
			int right = N;
			int mid = (left + right) / 2;
			while (left < right) {
 				if (treeLoc[mid] > photoLoc) {
					right = mid;
				} else if (treeLoc[mid] < photoLoc) {
					left = mid + 1;
				} else {
					 break;
				}

				mid = (left + right) / 2;
			}
//			System.out.println(mid);
			if (mid == 0) {
				sb.append(sum[N - 1] - photoLoc * N).append("\n");
			} else if (mid == N - 1 && photoLoc > treeLoc[N - 1]) {
				sb.append(photoLoc * N - sum[N - 1]).append("\n");
			} else {
				sb.append((mid * photoLoc - sum[mid - 1]) + ((sum[N - 1] - sum[mid - 1]) - photoLoc * (N - mid))).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}