import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] cnt = new int[1_000_001];
		int[] arr = new int[N];
		int sameCnt = (int)Math.ceil(M * 9 / 10.0);
		String result = "NO";

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i < M) {
				if (++cnt[arr[i]] >= sameCnt) {
					result = "YES";
					break;
				}
			}
		}

		if (result.equals("NO")) {
			for (int i = 1; i <= N - M; i++) {
				cnt[arr[i - 1]]--;

				if (++cnt[arr[i + M - 1]] >= sameCnt) {
					result = "YES";
					break;
				}
			}
		}

		System.out.println(result);
	}
}