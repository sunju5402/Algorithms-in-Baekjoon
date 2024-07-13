import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int[] arr = new int[N];
		int[] cnt = new int[d + 1];
		int kind = 1;
		cnt[c]++;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i < k) {
				if (++cnt[arr[i]] == 1) {
					kind++;
				}
			}
		}

		int result = kind;

		for (int i = 1; i < N; i++) {
			if (--cnt[arr[i - 1]] == 0) {
				kind--;
			}
			if (++cnt[arr[(i + k - 1) % N]] == 1) {
				kind++;
			}
			result = Math.max(result, kind);
		}

		System.out.println(result);
	}
}