import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int[] arr = new int[N];
		int[] result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				result[stack.pop()] = arr[i];
			}
			stack.add(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (result[i] == 0) result[i] = -1;
			sb.append(result[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}