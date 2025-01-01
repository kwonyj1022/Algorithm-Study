import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            sb.append(solve(N, coin, M)).append("\n");
        }
        System.out.print(sb);
    }

    static int solve(int n, int[] coin, int m) {
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                final int t = j - coin[i];
                if (t == 0) {
                    dp[j]++;
                } else if (t > 0) {
                    dp[j] = dp[j] + dp[t];
                }
            }
        }
        return dp[m];
    }
}
