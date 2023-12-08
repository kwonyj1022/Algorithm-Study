import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        boolean[] broken = new boolean[N + 1];
        for (int i = 0; i < B; i++) {
            broken[Integer.parseInt(br.readLine())] = true;
        }

        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (broken[i]) {
                sum[i] = sum[i - 1] + 1;
            } else {
                sum[i] = sum[i - 1];
            }
        }

        int answer = N;
        int t = N - K;
        for (int i = 0; i <= t; i++) {
            answer = Math.min(answer, sum[i + K] - sum[i]);
        }

        System.out.println(answer);
    }
}