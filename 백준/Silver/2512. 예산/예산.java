import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] arr;
    static int sum, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] input = br.readLine().split(" ");
        sum = 0;
        max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            sum += arr[i];
            max = Math.max(arr[i], max);
        }
        M = Integer.parseInt(br.readLine());
        if (sum <= M) {
            System.out.println(max);
            return;
        }
        int l = 0;
        int r = max;
        while (l < r) {
            int mid = (l + r) / 2;
            sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }
            if (sum < M) {
                l = mid + 1;
            } else if (sum > M) {
                r = mid;
            } else {
                System.out.println(mid);
                return;
            }
        }
        System.out.println(l - 1);
    }
}
