import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[] arr = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			arr[i] = true;
		}

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (arr[i]) {
				int j = 2;
				while (i * j <= N) {
					arr[i * j] = false;
					j += 1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (arr[i]) {
				sb.append(i).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}