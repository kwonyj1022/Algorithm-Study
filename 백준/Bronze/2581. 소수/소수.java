import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[10001];
        arr[1] = true;
        for (int i = 2; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (j % i == 0) {
                    arr[j] = true;
                }
            }
        }

        long sum = 0;
        for (int i = M; i <= N; i++) {
            if (!arr[i]) {
                sum += i;
            }
        }

        int min = 0;
        for (int i = M; i <= N; i++) {
            if (!arr[i]) {
                min = i;
                break;
            }
        }

        if (sum == 0) {
            System.out.print(-1);
        } else {
            System.out.print(sum + "\n" + min);
        }
    }
}