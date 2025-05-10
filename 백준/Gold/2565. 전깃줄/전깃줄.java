import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<int[]> line;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        line = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            line.add(new int[]{a, b});
        }
        line.sort((o1, o2) -> o1[0] - o2[0]);
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (line.get(i)[1] > line.get(j)[1]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
            if (dp1[i] == 0) {
                dp1[i] = 1;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (line.get(i)[1] < line.get(j)[1]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
            if (dp2[i] == 0) {
                dp2[i] = 1;
            }
        }
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < N; i++) {
            max1 = Math.max(max1, dp1[i]);
            max2 = Math.max(max2, dp2[i]);
        }
        System.out.print(Math.max(N - max1, N - max2));
	}
}
