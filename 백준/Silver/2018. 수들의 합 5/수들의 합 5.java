import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int p1 = 1, p2 = 1;
		int cnt = 0;
		int total = p1;

		while (p1 <= p2) {
			if (total == N) {
				cnt++;
			}

			if (total <= N) {
				p2++;
				total += p2;
			} else {
				total -= p1;
				p1++;
			}
		}

		System.out.println(cnt);
	}
}