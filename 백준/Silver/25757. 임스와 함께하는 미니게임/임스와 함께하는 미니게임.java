import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		char type = st.nextToken().charAt(0);

		int size = 0;

		if (type == 'Y') {
			size = 1;
		} else if (type == 'F') {
			size = 2;
		} else {
			size = 3;
		}

		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		System.out.println(set.size() / size);
	}
}