import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] st;
		Stack<Integer> q = new Stack<>();
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			st = br.readLine().split(" ");
			if (st.length == 2) {
				q.add(Integer.parseInt(st[1]));
			} else {
				if (st[0].equals("empty")) {
					if (q.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
				} else if (st[0].equals("pop")) {
					if (q.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(q.pop()).append("\n");
					}
				} else if (st[0].equals("top")) {
					if (q.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(q.peek()).append("\n");
					}
				} else
					sb.append(q.size()).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}