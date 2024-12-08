import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum[i] = sum[i - 1] + arr[i];
        }
        int L = Integer.parseInt(br.readLine());
        double mid = L / 2.0;
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            int t = Integer.parseInt(br.readLine());
            double m = sum[t - 1] + arr[t] / 2.0;
            double p = Math.max(0, m - mid);
            if (m + mid > sum[N]) {
                sb.append(String.format("%.2f\n", (double) Math.max(0, sum[N] - L)));
            } else {
                sb.append(String.format("%.2f\n", p));
            }
        }
        System.out.print(sb);
    }
}
