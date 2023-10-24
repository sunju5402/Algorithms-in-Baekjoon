import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int p1 = 0;
		int p2 = N - 1;
		long a = 0, b = 0;
		long min = Integer.MAX_VALUE;
		while (p1 < p2) {
			long tmp = Math.abs(arr[p1] + arr[p2]);
			if (min > tmp) {
				min = tmp;
				a = arr[p1];
				b = arr[p2];
			}

			if ((arr[p1] + arr[p2]) >= 0) {
				p2--;
			} else {
				p1++;
			}
		}

		System.out.println(a + " " + b);
	}
}