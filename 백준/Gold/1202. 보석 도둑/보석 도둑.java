import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr1 = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr1[i][0] = Integer.parseInt(st.nextToken());
			arr1[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] arr2 = new int[K];

		for (int i = 0; i < K; i++) {
			arr2[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr1, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});
		Arrays.sort(arr2);

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int i = 0;
		long result = 0;

		for (int j = 0; j < K; j++) {
			// while (i < N && arr1[i][0] <= arr2[j]) {
			// 	pq.add(arr1[i++][1]);
			// }
			for (int k = i; k < N; k++) {
				if (arr1[k][0] <= arr2[j]) {
					pq.add(arr1[k][1]);
				} else {
					i = k;
					break;
				}
				i = k + 1;
			}

			if (!pq.isEmpty()) {
				result += pq.poll();
			}
		}

		System.out.println(result);
	}
}