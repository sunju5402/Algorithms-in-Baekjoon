import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 0);
		}

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if (map.containsKey(tmp)) {
				list.add(tmp);
			}
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.print(sb.toString());
	}
}