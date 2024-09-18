import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int sum = 0;
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            double avg = (double) sum / N;
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] > avg) {
                    cnt++;
                }
            }
            final double rate = Math.round(cnt * 100000.0 / N) / 1000.0;
            sb.append(String.format("%.03f%%\n", rate));
        }
        System.out.print(sb);
    }
}