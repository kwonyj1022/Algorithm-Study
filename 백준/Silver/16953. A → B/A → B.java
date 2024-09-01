import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(B);
        Set<Integer> visited = new HashSet<>();
        visited.add(B);
        int cnt = 1;
        while (!q.isEmpty()) {
            int n = q.poll();
            if (n == A) {
                System.out.print(cnt);
                return;
            }
            cnt++;
            if (n % 2 == 0) {
                int t = n / 2;
                if (t > 0 && !visited.contains(t)) {
                    q.offer(t);
                    visited.add(t);
                }
            }
            if (n % 10 == 1) {
                int t = (n - 1) / 10;
                if (t > 0 && !visited.contains(t)) {
                    q.offer(t);
                    visited.add(t);
                }
            }
        }
        System.out.print(-1);
    }
}
