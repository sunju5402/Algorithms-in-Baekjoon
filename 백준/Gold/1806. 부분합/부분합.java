import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];

		int p1 = 0 , p2 = -1;

		for (int i = 0; i < N; i++) {
			if (i == 0) {
				arr[i] = Integer.parseInt(st.nextToken());
			} else {
				arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
			}

			if (p2 == -1 && arr[i] >= S) {
				p2 = i;
			}
		}

		int result = p2 + 1;
		while (p2 < N && p1 < p2) {
			int sum = arr[p2] - arr[p1];

			if (sum >= S) {
				result = Math.min(result, p2 - p1);
			}

			if ((arr[p2] - arr[p1]) < S) {
				p2++;
			} else {
				p1++;
			}
		}

		System.out.println(result);
	}
}