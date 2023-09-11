import java.io.*;
import java.util.*;

public class Main {

	static int n, size;
	static int result;
	static int[] arr;
	static int[][][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine()); // 벽장의 개수

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 초기에 열려있는 벽장
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

		size  = Integer.parseInt(br.readLine()); // 사용할 벽장 길이
		arr = new int[size];
 		for (int i = 0; i < size; i++) {
			 arr[i] = Integer.parseInt(br.readLine());
		}

		memo = new int[size][n + 1][n + 1];
		result = dfs(0, a, b);
		System.out.println(result);
	}

	private static int dfs(int idx, int a, int b) {
		if (idx == size) {
			return 0;
		}

		if (memo[idx][a][b] != 0) return memo[idx][a][b];

		int aDiff = Math.abs(a - arr[idx]) + dfs(idx + 1, arr[idx], b);
		int bDiff = Math.abs(b - arr[idx]) + dfs(idx + 1, a, arr[idx]);
		int total = result + Math.min(aDiff, bDiff);
		memo[idx][a][b] = total;
		
		return total;
	}
}