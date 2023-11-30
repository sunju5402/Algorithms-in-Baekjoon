import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		String[] arr = new String[N];
		String s;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			map.put(s, i + 1);
			arr[i] = s;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			if (Character.isDigit(s.charAt(0))) {
				sb.append(arr[Integer.parseInt(s) - 1]).append("\n");
			} else {
				sb.append(map.get(s)).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}