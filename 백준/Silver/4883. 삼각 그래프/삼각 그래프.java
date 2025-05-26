import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        for(int t = 1; ; t++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            int[][] graph = new int[N][3];
            int[][] dp = new int[N][3];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                graph[i][0] = Integer.parseInt(st.nextToken());
                graph[i][1] = Integer.parseInt(st.nextToken());
                graph[i][2] = Integer.parseInt(st.nextToken());
            }
            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = graph[0][1];
            dp[0][2] = dp[0][1] + graph[0][2];

            for (int i = 1; i < N; i++) {
                dp[i][0] = graph[i][0] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = graph[i][1] + Math.min(Math.min(dp[i][0], dp[i - 1][0]), Math.min(dp[i - 1][1], dp[i - 1][2]));
                dp[i][2] = graph[i][2] + Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2]));
            }
            sb.append(t).append(". ").append(dp[N - 1][1]).append('\n');
        }
        System.out.print(sb);
	}
}
