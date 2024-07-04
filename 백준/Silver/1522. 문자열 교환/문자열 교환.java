import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int result = Integer.MAX_VALUE;

		int aCnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				aCnt++;
			}
		}

		for (int i = 0; i < str.length(); i++) {
			int bCnt = 0;
			for (int j = i; j < i + aCnt; j++) {
				int idx = j % str.length(); // 원형이므로 나머지 연산
				if (str.charAt(idx) == 'b') {
					bCnt++;
				}
			}

			result = Math.min(result, bCnt);
		}

		System.out.println(result);
	}
}
