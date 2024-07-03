import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N];
		int idx = -1;
		long zeroCnt = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			//if (arr[i] == 0) {
				//zeroCnt++;
			//}
		}

		Arrays.sort(arr);

		//for (int i = 0; i < N; i++) {
			//if (arr[i] >= 0) {
			//	idx = i;
			//	break;
			//}
		//}

		long result = 0;

		//if (idx == 0) {
		//	if (zeroCnt >= 3) {
		//		result += zeroCnt * (zeroCnt - 1) * (zeroCnt - 2) / 6;
			//}
	//	} else if (idx > 0) { // 주어진 수가 모두 음수거나 양수일 경우를 제외
			for (int i = 0; i < N; i++) {
				int p1 = i + 1;
				int p2 = N - 1;

				while (p1 < p2) {
					int total = arr[p1] + arr[p2] + arr[i];
					if (total == 0) {
						if (arr[p1] == arr[p2]) {
							result += (long)(p2 - p1 + 1) * (p2 - p1) / 2;
							break;
						} else {
							long rightCnt = 1;
							while (arr[p2] == arr[p2 - 1]) {
								rightCnt++;
								p2--;
							}

							long leftCnt = 1;
							while (arr[p1] == arr[p1 + 1]) {
								leftCnt++;
								p1++;
							}
							result += rightCnt * leftCnt;
							p1++;
						}
					} else if (total > 0) {
						p2--;
					} else {
						p1++;
					}
				}
			}

			// for (int i = idx; i < N; i++) {
			// 	int p1 = 0;
			// 	int p2 = idx - 1;
			//
			// 	while (p1 < p2) {
			// 		int total = arr[p1] + arr[p2] + arr[i];
			// 		if (total == 0) {
			// 			if (arr[p1] == arr[p2]) {
			// 				result += (long)(p2 - p1 + 1) * (p2 - p1) / 2;
			// 				break;
			// 			} else {
			// 				long rightCnt = 1;
			// 				while (p1 < p2 - 1 && arr[p2] == arr[p2 - 1]) {
			// 					rightCnt++;
			// 					p2--;
			// 				}
			//
			// 				long leftCnt = 1;
			// 				while (p1 + 1 < p2 && arr[p1] == arr[p1 + 1]) {
			// 					leftCnt++;
			// 					p1++;
			// 				}
			// 				result += rightCnt * leftCnt;
			// 				p1++;
			// 			}
			// 		} else if (total > 0) {
			// 			p2--;
			// 		} else {
			// 			p1++;
			// 		}
			// 	}
			// }
	//	}

		System.out.println(result);
	}
}