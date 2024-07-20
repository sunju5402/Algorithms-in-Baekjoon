import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] days = new int[N];

		long total = 0L;
		int dayCnt = 1;
		for (int i = 0; i < N; i++) {
			days[i] = Integer.parseInt(st.nextToken());
			if (i < X) {
				total += days[i];
			}
		}

		long result = total;
		for (int i = 0; i < N - X; i++) {
			total -= days[i];
			total += days[i + X];
			if (result < total) {
				result = total;
				dayCnt = 1;
			} else if (result == total) {
				dayCnt++;
			}
		}

		if (result == 0L) {
			System.out.println("SAD");
		} else {
			System.out.println(result);
			System.out.println(dayCnt);
		}
	}
}