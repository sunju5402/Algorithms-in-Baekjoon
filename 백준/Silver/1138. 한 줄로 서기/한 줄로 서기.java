import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N + 1];
		int[] result = new int[N];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			int j = 0;

			while (true) {
				if (arr[i] == 0 && result[j] == 0) {
					result[j] = i;
					break;
				} else if (result[j] == 0) {
					arr[i]--;
				}
				j++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int n : result) {
			sb.append(n).append(" ");
		}

		System.out.print(sb.toString());
	}
}