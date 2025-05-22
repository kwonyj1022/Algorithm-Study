import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][2];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 2];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            
            // max = Math.max(dp[i], max);
            int next = i + arr[i][0] - 1;
            if (next <= N) {
                dp[next] = Math.max(dp[next], dp[i - 1] + arr[i][1]);
            }
        }
        System.out.print(dp[N]);
	}
}
