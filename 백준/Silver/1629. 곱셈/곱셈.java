import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		System.out.println(solve(A,  B, C));
	}

	private static long solve(int A,  int B, int C) {
		if (B == 1) {
			return A % C;
		}

		long num = solve(A, B / 2, C);

		if (B % 2 == 0) {
			return num * num % C;
		}
		return (num * num % C) * A % C;
	}
}