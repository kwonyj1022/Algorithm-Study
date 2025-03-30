import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean[] prime;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        prime = new boolean[1000001];
        setupPrime();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            if (N % 2 == 0 && N != 0) {
                for (int j = 2; j <= N / 2; j++) {
                    if (!prime[j]) {
                        if (!prime[N - j]) {
                            cnt++;
                        }
                    }
                }
                sb.append(cnt).append('\n');
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);
    }

    static void setupPrime() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i * 2; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
}
