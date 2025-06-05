import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            Deque<Character> dq = new ArrayDeque<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            dq.addLast(st.nextToken().charAt(0));
            for (int i = 1; i < N; i++) {
                char c = st.nextToken().charAt(0);
                if (c <= dq.peekFirst()) {
                    dq.addFirst(c);
                } else {
                    dq.addLast(c);
                }
            }
            while(!dq.isEmpty()) {
                sb.append(dq.pollFirst());
            }
            sb.append('\n');
        }
        System.out.print(sb);
	}
}
