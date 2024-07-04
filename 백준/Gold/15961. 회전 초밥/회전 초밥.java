import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] tmp = new int[d + 1];
		int[] arr = new int[N + k];
	
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k; i++) {
			arr[i + N] = arr[i];
			tmp[arr[i]]++;
		}
		tmp[c]++;
		
		int cnt = 0;
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] >= 1) {
				cnt++;
			}
		}
		
		int maxCnt = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if (++tmp[arr[i + k - 1]] == 1) {
				cnt++;
			}
			if (--tmp[arr[i - 1]] == 0) {
				cnt--;
			}
			
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		System.out.println(maxCnt);
	}
}