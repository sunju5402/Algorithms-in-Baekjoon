import java.io.*;
import java.util.*;

public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());

			StringTokenizer st;
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}

			for (int i = 0; i < N; i++) {
				if (i == (N - 1)) {
					System.out.println(pq.poll());
				} else {
					pq.poll();
			}
		}
	}
}
