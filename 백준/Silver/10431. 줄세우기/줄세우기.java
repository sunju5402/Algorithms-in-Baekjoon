import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int P = Integer.parseInt(br.readLine());

		StringTokenizer st;
		ArrayList<Integer> list;
		StringBuilder sb = new StringBuilder();
		int[] arr;

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			arr = new int[20];

			int result = 0;

			for (int j = 0; j < 20; j++) {
				int n = Integer.parseInt(st.nextToken());
				arr[j] = n;
				for (int k = 0; k < j; k++) {
					if (arr[k] > n) {
						for (int l = j; l > k; l--) {
							arr[l] = arr[l - 1];
							result++;
						}
						arr[k] = n;
						break;
					}
				}
			}

			sb.append(i + 1).append(" ").append(result).append("\n");
		}

		System.out.print(sb.toString());
	}
}