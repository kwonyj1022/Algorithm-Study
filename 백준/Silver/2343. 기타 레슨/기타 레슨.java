import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int l = 0;
        int r = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            l = Math.max(l, arr[i]);
            r += arr[i];
        }
        while (l <= r) {
            int m = (l + r) / 2;
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > m) {
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (sum > 0) {
                cnt++;
            }
            if (cnt > M) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println(l);
    }
}