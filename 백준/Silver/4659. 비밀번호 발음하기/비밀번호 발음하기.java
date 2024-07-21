import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		StringBuilder sb = new StringBuilder();

		while (!s.equals("end")) {
			int cnt1 = 0;
			int cnt2 = 0;
			boolean checked = false;
			String ss = "";
			String sss = "";
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
				|| s.charAt(i) == 'o' || s.charAt(i) == 'u') {
					cnt1++;
					ss += s.charAt(i);
					checked = true;
					cnt2 = 0;
					sss = "";
				} else {
					cnt2++;
					sss += s.charAt(i);
					cnt1 = 0;
					ss = "";
				}

				if (cnt1 == 2 && ss.charAt(0) == ss.charAt(1)) {
					if (ss.equals("ee") || ss.equals("oo")) {
						checked = true;
					} else {
						checked = false;
						break;
					}
				}

				if (cnt2 == 2 && sss.charAt(0) == sss.charAt(1)) {
					checked = false;
					break;
				}

				if (cnt1 == 3 || cnt2 == 3) {
					checked = false;
					break;
				}
			}

			if (checked) {
				sb.append("<" + s + ">" + " is acceptable.").append("\n");
			} else {
				sb.append("<" + s + ">" + " is not acceptable.").append("\n");
			}

			s = br.readLine();
		}

		System.out.print(sb.toString());
	}
}