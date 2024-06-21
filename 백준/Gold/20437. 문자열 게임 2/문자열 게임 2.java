import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<ArrayList<Integer>> list;
		for (int t = 0; t < T; t++) {
			list = new ArrayList<>();
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());

			for (int i = 0; i < 26; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 0; i < W.length(); i++) {
				list.get(W.charAt(i) - 'a').add(i);
			}

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (ArrayList<Integer> alphabet : list) {
				if (alphabet.size() < K) {
					continue;
				}

				for (int j = 0; j <= alphabet.size() - K; j++) {
					min = Math.min(min, alphabet.get(j + K - 1) - alphabet.get(j) + 1);
					max = Math.max(max, alphabet.get(j + K - 1) - alphabet.get(j) + 1);
				}
			}

			if (min == Integer.MAX_VALUE) {
				sb.append(-1).append("\n");
			} else {
				sb.append(min).append(" ").append(max).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}