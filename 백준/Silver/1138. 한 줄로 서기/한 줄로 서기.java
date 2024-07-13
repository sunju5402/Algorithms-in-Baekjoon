import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N + 1];
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N; i >= 1; i--) {
			list.add(arr[i], i);
		}

		StringBuilder sb = new StringBuilder();
		for (int n : list) {
			sb.append(n).append(" ");
		}

		System.out.print(sb.toString());
	}
}