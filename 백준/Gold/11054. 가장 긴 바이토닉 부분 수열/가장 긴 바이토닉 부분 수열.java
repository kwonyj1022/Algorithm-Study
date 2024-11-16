import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] positive = new int[N];
        int[] negative = new int[N];
        for (int i = 0; i < N; i++) {
            positive[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    positive[i] = Math.max(positive[j] + 1, positive[i]);
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            negative[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    negative[i] = Math.max(negative[j] + 1, negative[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, positive[i] + negative[i]);
        }
        System.out.print(max - 1);
    }
}
