import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] stair;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stair = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stair[1];
        if (n > 1) {
            dp[2] = stair[1] + stair[2];
        }

        System.out.print(solve(n));
    }

    static int solve(int n) {
        if (n <= 0) {
            return 0;
        }
        if (dp[n] == 0) {
            dp[n] = Math.max(solve(n - 2), solve(n - 3) + stair[n - 1]) + stair[n];
        }
        return dp[n];
    }
}