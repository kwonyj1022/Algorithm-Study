import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] <= arr[j]) {
                    continue;
                }
                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
        }

        int maxIdx = 0;
        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxVal) {
                maxIdx = i;
                maxVal = dp[i];
            }
        }
        Stack<Integer> stack = new Stack<>();
        while (maxIdx != -1) {
            stack.add(arr[maxIdx]);
            maxIdx = parent[maxIdx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxVal).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.print(sb);
	}
}
