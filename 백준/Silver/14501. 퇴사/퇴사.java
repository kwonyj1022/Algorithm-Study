import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int yesterday = i - 1;
            int end = i + T[i] - 1;
            dp[i] = Math.max(dp[i], dp[yesterday]);
            if (end <= N) {
                dp[end] = Math.max(dp[end], dp[yesterday] + P[i]);
            }
        }
        System.out.print(dp[N]);
    }
}
