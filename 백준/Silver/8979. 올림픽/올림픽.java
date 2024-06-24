import java.io.*;
import java.util.*;

public class Main {

	static class Medal implements Comparable<Medal>
	{
		int n;
		int gold;
		int silver;
		int bronze;

		public Medal(int n, int gold, int silver, int bronze) {
			this.n = n;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Medal o) {
			if (this.gold == o.gold) {
				if (this.silver == o.silver) {
					return Integer.compare(o.bronze, this.bronze);
				}
				return Integer.compare(o.silver, this.silver);
			}
			return Integer.compare(o.gold, this.gold);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<Medal> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			pq.add(new Medal(n, gold, silver, bronze));
		}


		int result = 1;
		int cnt = 1;

		Medal cur = pq.poll();
		if (K == cur.n) {
			System.out.println(1);
		} else {
			while (!pq.isEmpty()) {
				Medal next = pq.poll();

				if (cur.gold == next.gold && cur.silver == next.silver && cur.bronze == next.bronze) {
					cnt++;
				} else {
					result += cnt;
					cnt = 1;
				}

				if (K == next.n) {
					System.out.println(result);
					break;
				}

				cur = next;
			}
		}
	}
}
