import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int N;
    static Queue<String>[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new Queue[N];
        for (int i = 0; i < N; i++) {
            S[i] = new ArrayDeque<>();
            String[] si = br.readLine().split(" ");
            for (int j = 0; j < si.length; j++) {
                S[i].offer(si[j]);
            }
        }

        String[] L = br.readLine().split(" ");
        int idx = 0;
        while (idx < L.length) {
            boolean exists = false;
            for (int i = 0; i < N; i++) {
                if (L[idx].equals(S[i].peek())) {
                    exists = true;
                    S[i].poll();
                    break;
                }
            }
            if (!exists) {
                System.out.print("Impossible");
                return;
            }
            idx++;
        }

        for (int i = 0; i < N; i++) {
            if (!S[i].isEmpty()) {
                System.out.print("Impossible");
                return;
            }
        }

        System.out.print("Possible");
    }
}
