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
        f(N, Math.min(K, N - K));
    }

    public static void f(int n, int k) {
        int t1 = 1;
        int t2 = 1;
        for (int i = 0; i < k; i++) {
            t1 *= (n - i);
            t2 *= (k - i);
        }
        System.out.println(t1 / t2);
    }
}