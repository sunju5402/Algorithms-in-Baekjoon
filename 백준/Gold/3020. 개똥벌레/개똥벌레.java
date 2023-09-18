import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] obstacles = new int[N]; // 장애물
		for (int i = 0; i < N; i++) {
			obstacles[i] = Integer.parseInt(br.readLine());
		}

		int[] sum = new int[H + 1];
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) { // 석순일 경우
				sum[H - obstacles[i] + 1] += 1;
			} else { // 종유석일 경우
				sum[1] += 1;
				sum[1 + obstacles[i]] -= 1;
			}
		}

		int result = Integer.MAX_VALUE;
		int cnt = 0;
		for (int i = 1; i <= H; i++) {
			sum[i] += sum[i - 1];
			if (result > sum[i]) {
				result = sum[i];
				cnt = 1;
			} else if (result == sum[i]) {
				cnt++;
			}
		}

		System.out.println(result + " " + cnt);
	}
}