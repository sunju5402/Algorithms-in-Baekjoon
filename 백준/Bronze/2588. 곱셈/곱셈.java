import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		String b = br.readLine();

		StringBuilder sb = new StringBuilder();
		int total = 0;
		for (int i = 0; i < 3; i++) {
			int tmp = a * (b.charAt(3 - i - 1) - '0');
			sb.append(tmp).append("\n");
			total += tmp * (int)Math.pow(10, i);
		}
		sb.append(total);
		System.out.println(sb.toString());
	}
}