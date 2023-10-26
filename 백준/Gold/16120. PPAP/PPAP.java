import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		String result = "PPAP";
		int pCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				if (pCount < 2 || (i + 1) >= s.length() || s.charAt(i + 1) != 'P') {
					result = "NP";
					break;
				} else {
					pCount -= 1;
					i++;
				}
			} else {
				pCount++;
			}
		}

		if (pCount > 1) result = "NP";
		System.out.println(result);
	}
}
