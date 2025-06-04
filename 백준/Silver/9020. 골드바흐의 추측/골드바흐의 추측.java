import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        preprocess();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int left = n / 2;
            int right = n / 2;

            while (true) {
                if (!prime[left] && !prime[right]) {
                    sb.append(left).append(' ').append(right).append('\n');
                    break;
                }
                left--;
                right++;
            }
        }
        System.out.print(sb);
    }

    static void preprocess() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i * i <= prime.length; i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
