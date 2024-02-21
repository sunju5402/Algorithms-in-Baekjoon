import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] top = new int[N + 1];
		int[] bottom = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = 0;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if (num > 0) {
				top[num]++;
			} else {
				bottom[-num]++;
			}
		}

		for (int i = 1; i <= N; i++) {
			top[i] += top[i - 1];
			bottom[N - i] += bottom[N - i + 1];
		}

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 0; i <= N; i++) {
			if (((top[N] - top[i]) + (bottom[0] - bottom[i])) == i) {
				sb.append(i).append(" ");
				cnt++;
			}
		}

		System.out.println(cnt);
		if (cnt > 0) {
			System.out.println(sb.toString());
		}
	}
}