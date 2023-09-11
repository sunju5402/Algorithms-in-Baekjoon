import java.io.*;
import java.util.*;

public class Main {

	static int n, size, a, b;
	static int result;
	static int[] arr;
	static int[] open;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine()); // 벽장의 개수

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 초기에 열려있는 벽장
		open = new int[2];
		for (int i = 0; i < 2; i++) {
			open[i] = Integer.parseInt(st.nextToken());
		}

		size  = Integer.parseInt(br.readLine()); // 사용할 벽장 길이
		arr = new int[size];
 		for (int i = 0; i < size; i++) {
			 arr[i] = Integer.parseInt(br.readLine());
		}

		 result = Integer.MAX_VALUE;
		 dfs(0, 0);

		System.out.println(result);
	}

	private static void dfs(int idx, int total) {
        if (result <= total) return;
        
		if (idx == size) {
			result = Math.min(result, total);
			return;
		}

		for (int i = 0; i < 2; i++) {
			int tmp = open[i];
			int diff = Math.abs(open[i] - arr[idx]);
			open[i] = arr[idx];
			dfs(idx + 1, total + diff);
			open[i] = tmp;
		}
	}
}