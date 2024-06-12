import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		boolean valid = true;
		int cnt = 0;
		while (true) {
			if (B == A) {
				break;
			} else if (B < A) {
				valid = false;
				break;
			}

			if (B % 2 == 0) {
				B /= 2;
			} else {
				if (B % 10 == 1) {
					B /= 10;
				} else {
					valid = false;
					break;
				}
			}

			cnt++;
		}

		System.out.println(valid ? cnt + 1 : -1);
	}
}
