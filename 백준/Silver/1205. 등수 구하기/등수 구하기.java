import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		Integer[] arr = new Integer[N];

		if (N > 0) {
			st = new StringTokenizer(br.readLine(), " ");
		}

		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, Collections.reverseOrder());

		if(N == p && score <= arr[arr.length-1])
			System.out.print(-1);
		else {
			int rank = 1;
			for (int i = 0; i < arr.length; i++) {
				if (score < arr[i])
					rank++;
				else
					break;
			}

			System.out.print(rank);
		}
	}
}