import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[1_000_001];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			arr[x] = g;
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (i >= (K * 2 + 1)) {
				sum -= arr[i - (K * 2 + 1)];
			}
			sum += arr[i];
			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}