import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] KN = br.readLine().split(" ");
        int K = Integer.parseInt(KN[0]);
        int N = Integer.parseInt(KN[1]);

        int[] KArr = new int[K];
        for (int i = 0; i < K; i++) {
            KArr[i] = Integer.parseInt(br.readLine());
        }

        long maxK = KArr[0];
        for (int i = 1; i < K; i++) {
            if (KArr[i] > maxK) {
                maxK = KArr[i];
            }
        }

        long max = 0;
        long l = 1;
        long r = maxK;
        while (l <= r) {
            long m = (l + r) / 2;
            long tmpN = 0;
            for (int i = 0; i < K; i++) {
                tmpN += KArr[i] / m;
            }
            if (tmpN >= N) {
                l = m + 1;
                if (m > max) {
                    max = m;
                }
            } else {
                r = m - 1;
            }
        }
        System.out.println(max);
    }
}