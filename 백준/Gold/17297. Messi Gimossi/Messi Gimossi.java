import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int M;
	static String str1, str2;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		M = Integer.parseInt(br.readLine());
		str1 = "Messi";
		str2 = "Messi Gimossi";

		list = new ArrayList<>();
		list.add(5);
		list.add(13);
		int n1 = 5;
		int n2 = 13;
		while (n2 < M) {
			int tmp = n2;
			n2 += n1 + 1;
			n1 = tmp;
			list.add(n2);
		}

		char result = solve(list.size() - 1, M);
		if (result == ' ') {
			System.out.println(str1 + " " + str2);
		} else {
			System.out.println(result);
		}
	}

	private static char solve(int n, int m) {
		if (n == 0) return str1.charAt(m - 1);
		if (n == 1) return str2.charAt(m - 1);

		int mid = list.get(n - 1) + 1;
		if (m == mid) {
			return ' ';
		} else if (m < mid) {
			return solve(n - 1, m);
		} else {
			return solve(n - 2, m - (list.get(n - 1) + 1));
		}
	}
}
