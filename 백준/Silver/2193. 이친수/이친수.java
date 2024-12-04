import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[2][N + 1];
        if (N == 1 || N == 2) {
            System.out.print(1);
            return;
        }
        dp[0][1] = 0;
        dp[1][1] = 1;
        dp[0][2] = 1;
        dp[1][2] = 0;
        for (int i = 3; i <= N; i++) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[1][i] = dp[0][i - 1];
        }
        System.out.print(dp[0][N] + dp[1][N]);
    }
}
