import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> ppq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mpq = new PriorityQueue<>();
        int sum = 0;
        boolean containsZero = false;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                containsZero = true;
            } else if (n == 1) {
                sum++;
            } else if (n < 0) {
                mpq.offer(n);
            } else {
                ppq.offer(n);
            }
        }
        while (ppq.size() > 1) {
            int n1 = ppq.poll();
            int n2 = ppq.poll();
            sum += n1 * n2;
        }
        if (!ppq.isEmpty()) {
            sum += ppq.poll();
        }
        while (mpq.size() > 1) {
            int n1 = mpq.poll();
            int n2 = mpq.poll();
            sum += n1 * n2;
        }
        if (!mpq.isEmpty() && !containsZero) {
            sum += mpq.poll();
        }
        System.out.print(sum);
    }
}