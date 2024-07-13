import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

		int maxL = arr[0][0];
		int maxH = arr[0][1];
		int result = 0;
		Stack<int[]> stack = new Stack<>();

		for (int i = 1; i < N; i++) {
			if (arr[i][1] > maxH) {
				result += (arr[i][0] - maxL) * maxH;

				maxL = arr[i][0];
				maxH = arr[i][1];

				stack.clear();
			} else {
				stack.add(new int[]{arr[i][0], arr[i][1]});
			}
		}
		result += maxH;

		if (!stack.empty()) {
			int[] tmp = stack.pop();
			int maxL2 = tmp[0];
			int maxH2 = tmp[1];
			while (!stack.empty()) {
				tmp = stack.pop();
				if (tmp[1] > maxH2) {
					result += (maxL2 - tmp[0]) * maxH2;

					maxL2 = tmp[0];
					maxH2 = tmp[1];
				}
			}

			result += (maxL2 - maxL) * maxH2;
		}

		System.out.println(result);
	}
}