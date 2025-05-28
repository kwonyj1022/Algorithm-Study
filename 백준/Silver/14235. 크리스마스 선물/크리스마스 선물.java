import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int n = Integer.parseInt(br.readLine());
        String a;
        StringTokenizer st;
        while (n-- > 0) {
            a = br.readLine();
            if ("0".equals(a)) {
                if (pq.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(pq.poll()).append('\n');
                }
                continue;
            }
            st = new StringTokenizer(a);
            st.nextToken();
            while (st.hasMoreTokens()) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        System.out.print(sb);
	}
}
