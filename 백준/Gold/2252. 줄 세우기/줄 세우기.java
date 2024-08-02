import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		int[] arr = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			arr[b]++;
		}
		
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0) {
				q.add(i);
				visited[i] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int n = q.poll();
			sb.append(n).append(" ");
			for (int i = 0; i < list.get(n).size(); i++) {
				arr[list.get(n).get(i)]--;
			}
			
			for (int i = 1; i < arr.length; i++) {
				if (!visited[i] && arr[i] == 0) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		System.out.print(sb.toString());
	}
}