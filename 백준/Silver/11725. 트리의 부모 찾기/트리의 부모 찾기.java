import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] result;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited = new boolean[N + 1];
        result = new int[N + 1];
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void dfs(int num) {
        visited[num] = true;

        for (int i = 0; i < list.get(num).size(); i++) {
            if (!visited[list.get(num).get(i)]) {
                result[list.get(num).get(i)] = num;
                dfs(list.get(num).get(i));
            }
        }

    }
}