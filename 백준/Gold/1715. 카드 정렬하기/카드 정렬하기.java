import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        if (N == 1) {
            System.out.print(0);
            return;
        }
        while (true) {
            int t1 = pq.poll();
            int t2 = pq.poll();
            int tsum = t1 + t2;
            sum += tsum;
            if (pq.isEmpty()) {
                break;
            }
            pq.offer(tsum);
        }
        System.out.print(sum);
    }
}
