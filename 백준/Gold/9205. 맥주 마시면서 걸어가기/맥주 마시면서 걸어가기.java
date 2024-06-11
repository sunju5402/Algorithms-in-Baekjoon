import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		List<int[]> list;
		Queue<int[]> q;
		boolean[] visited;
		boolean checked;
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int dx = 0;
			int dy = 0;
			visited = new boolean[n];
			list = new ArrayList<>();
			q = new ArrayDeque<>();
			checked = false;
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (i == 0) {
					q.add(new int[]{x, y});
				} else if (i == n + 1) {
					dx = x;
					dy = y;
				} else {
					list.add(new int[]{x, y});
				}
			}

			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				int x = tmp[0];
				int y = tmp[1];

				if ((Math.abs(x - dx) + Math.abs(y - dy)) <= 1000) {
					checked = true;
					break;
				}

				for (int i = 0; i < list.size(); i++) {
					int nx = list.get(i)[0];
					int ny = list.get(i)[1];
					if (!visited[i] && (Math.abs(x - nx) + Math.abs(y - ny)) <= 1000) {
						q.add(new int[]{nx, ny});
						visited[i] = true;
					}
				}
			}

			if (checked) {
				sb.append("happy").append("\n");
			} else {
				sb.append("sad").append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}