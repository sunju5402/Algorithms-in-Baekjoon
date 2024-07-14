import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] cnt = new int[100001];
		int p1 = 0, p2 = 1;
		cnt[arr[p1]]++;
		int result = 1;

		while (p2 < N && p1 <= p2) {
			if (cnt[arr[p2]] >= K) {
				result = Math.max(result, p2 - p1);
				cnt[arr[p1++]]--;
			} else {
				cnt[arr[p2++]]++;
			}
		}

		result = Math.max(result, p2 - p1);

		System.out.println(result);
	}
}