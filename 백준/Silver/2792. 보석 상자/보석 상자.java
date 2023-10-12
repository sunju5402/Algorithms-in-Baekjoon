import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] colors = new int[M];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			colors[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, colors[i]);
		}

		int cnt, mid = 0;
		int result = Integer.MAX_VALUE;
		int left = 1;
		int right = max;
		while (left <= right) {
			cnt = 0;
			mid = (left + right) / 2;
			for (int i = 0; i < M; i++) {
				cnt += colors[i] / mid;
				if (colors[i] % mid != 0) {
					cnt += 1;
				}
			}

			if (cnt > N) {
				left = mid + 1;
			} else {
				result = Math.min(result, mid);
				right = mid - 1;
			}
		}

		System.out.println(result);
	}
}