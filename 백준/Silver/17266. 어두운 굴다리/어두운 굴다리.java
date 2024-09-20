import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int result = 0;
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i > 0) {
				result = (int)Math.max(result, Math.ceil((arr[i] - arr[i - 1]) * 1.0 / 2));
			} else {
				result = arr[i];
			}
		}

		result = Math.max(result, N - arr[M - 1]);

		System.out.println(result);
	}
}