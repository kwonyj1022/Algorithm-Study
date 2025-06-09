import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= 40; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
        
        int prev = 0;
        int answer = 1;
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(br.readLine());
            answer *= dp[tmp - prev - 1];
            prev = tmp;
        }
        answer *= dp[N - prev];
        System.out.print(answer);
	}
}
