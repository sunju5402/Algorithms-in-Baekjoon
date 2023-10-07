import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 종류의 수
        int x = Integer.parseInt(st.nextToken()); // 파이프의 길이

        int[] L = new int[N];
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            L[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][x + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= C[i]; j++) {
                if (L[i] * j > x) break;
                dp[i][L[i] * j] = 1;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= x; j++) {
                for (int k = 0; k <= C[i]; k++) {
                    if (j - L[i] * k >= 0) {
                        dp[i][j] += dp[i - 1][j - L[i] * k];
                    }
                }
            }
        }

        System.out.println(dp[N - 1][x]);
    }
}