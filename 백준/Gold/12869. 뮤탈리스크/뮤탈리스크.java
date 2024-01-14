import java.io.*;
import java.util.*;

public class Main {

	static int N, result;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = Integer.MAX_VALUE;
		arr = new int[3];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(arr[0], arr[1], arr[2], new boolean[61][61][61], 0);

		System.out.println(result);
	}


	public static void dfs(int n1, int n2, int n3, boolean[][][] visited, int cnt) {
		n1 = Math.max(0, n1);
		n2 = Math.max(0, n2);
		n3 = Math.max(0, n3);

		if (n1 == 0 && n2 == 0 && n3 == 0) {
			result = Math.min(result, cnt);
            return;
		}
        
        int[] arr2 = {n1, n2, n3};
		Arrays.sort(arr2);
		n3 = arr2[0];
		n2 = arr2[1];
		n1 = arr2[2];

		if (visited[n1][n2][n3]) return;
		else visited[n1][n2][n3] = true;

		if (result < cnt) return;

		dfs(n1 - 9, n2 - 3, n3 - 1, visited, cnt + 1);
		dfs(n1 - 9, n2 - 1, n3 - 3, visited, cnt + 1);
		dfs(n1 - 3, n2 - 9, n3 - 1, visited, cnt + 1);
		dfs(n1 - 3, n2 - 1, n3 - 9, visited, cnt + 1);
		dfs(n1 - 1, n2 - 9, n3 - 3, visited, cnt + 1);
		dfs(n1 - 1, n2 - 3, n3 - 9, visited, cnt + 1);
	}
}
