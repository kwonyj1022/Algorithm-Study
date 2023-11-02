import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n > 1440) {
                System.out.println(-1);
                return;
            }
            if (N == 1) {
                System.out.println(n);
                return;
            }
            arr[i] = n;
            if (max < n) {
                max = n;
            }
            sum += n;
        }

        int answer = 0;
        int tmp = sum / 2;
        if (max > tmp) {
            answer = max;
        } else {
            answer = tmp + sum % 2;
        }
        if (answer > 1440) {
            answer = -1;
        }
        System.out.println(answer);
    }
}