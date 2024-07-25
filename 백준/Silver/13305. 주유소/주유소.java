import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] length = new int[N - 1];
		int[] price = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N - 1; i++) {
			length[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		int pre = 0;
		int next = 0;
		int result = length[pre] * price[pre];

		for (int i = 1; i < N - 1; i++) {
			next = i;
			if (price[pre] > price[next]) {
				pre = i;
			}

			result += length[i] * price[pre];
		}

		System.out.println(result);
	}
}