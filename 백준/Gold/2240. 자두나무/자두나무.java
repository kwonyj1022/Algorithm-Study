import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int[] arr = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][][] dp = new int[T + 1][W + 1][3];
        for (int t = 1; t <= T; t++) {
            dp[t][0][1] = dp[t - 1][0][1] + (arr[t] == 1 ? 1 : 0);
            for (int w = 1; w <= W; w++) {
                dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][2]) + (arr[t] == 1 ? 1 : 0);
                dp[t][w][2] = Math.max(dp[t - 1][w - 1][1], dp[t - 1][w][2]) + (arr[t] == 2 ? 1 : 0);
            }
        }
        System.out.print(Math.max(dp[T][W][1], dp[T][W][2]));
    }
}
