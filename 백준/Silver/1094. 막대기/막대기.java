import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        pq.offer(64);
        int sum = 64;
        while (true) {
            if (sum == X) {
                break;
            }
            int min = pq.poll();
            int half = min / 2;
            if (sum - half >= X) {
                pq.offer(half);
                sum -= half;
            } else {
                pq.offer(half);
                pq.offer(half);
            }
        }
        System.out.print(pq.size());
    }
}