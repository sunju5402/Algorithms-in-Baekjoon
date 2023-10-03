import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			String result = "YES";
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						result = "NO";
						break;
					} else {
						stack.pop();
					}
				} else {
					stack.add(str.charAt(j));
				}
			}

			if (!stack.isEmpty()) {
				result = "NO";
			}
			
			sb.append(result).append("\n");
		}

		System.out.print(sb.toString());
	}
}