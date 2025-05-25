import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            long sum = pq.poll() + pq.poll();
            pq.offer(sum);
            pq.offer(sum);
        }
        long answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.print(answer);
	}
}
