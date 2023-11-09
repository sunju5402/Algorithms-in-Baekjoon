import java.io.*;
import java.util.*;

public class Main {

	static long result;
	static int N, a, b, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken()); // 시작
		b = Integer.parseInt(st.nextToken()); // 더하고
		c = Integer.parseInt(st.nextToken()); // 곱한다.

		result = Integer.MIN_VALUE;
		solve((a + b) % 100000, N - 1, N);
		System.out.println(result);
	}

	private static void solve(long total, int white, int dark) {
		if (white == 0 && dark == 0) {
//			System.out.println("0 : " + total + " " + white + " " + dark);
			result = Math.max(result, total % 100000);
		}

		if (white > 0 && white <= dark) {
//			System.out.println("1 : " + total + " " + white + " " + dark);
			solve((total + b)  % 100000, white - 1, dark);

		}
		if (dark > 0) {
//			System.out.println("2 : " + total + " " + white + " " + dark);
			solve(total * c % 100000, white, dark - 1);

		}
	}
}