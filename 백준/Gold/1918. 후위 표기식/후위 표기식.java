import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			switch (c) {
				case '+':
				case '-':
				case '*':
				case '/':
					while (!stack.isEmpty() && solve(stack.peek()) >= solve(c)) {
						sb.append(stack.pop());
					}
					stack.add(c);
					break;
				case '(':
					stack.add(c);
					break;
				case ')':
					while (!stack.isEmpty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop();
					break;
				default:
					sb.append(c);
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
	}

	private static int solve(char op) {
		if (op == '(' || op == ')') {
			return 0;
		} else if (op == '+' || op == '-') {
			return 1;
		} else {
			return 2;
		}
	}
}