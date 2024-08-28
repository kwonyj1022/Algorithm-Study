import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long t = (long) Math.sqrt(n);
        long cnt = n;
        for (int i = 2; i <= t; i++) {
            if (n % i == 0) {
                cnt -= cnt / i;
                while(n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            cnt -= cnt / n;
        }
        System.out.print(cnt);
    }
}
