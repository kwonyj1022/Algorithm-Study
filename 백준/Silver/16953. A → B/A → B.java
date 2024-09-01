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
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(B, 1));
        Set<Integer> visited = new HashSet<>();
        visited.add(B);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.n % 2 == 0) {
                int t = node.n / 2;
                if (t == A) {
                    System.out.print(node.cnt + 1);
                    return;
                }
                if (t > 0 && !visited.contains(t)) {
                    q.offer(new Node(t, node.cnt + 1));
                    visited.add(t);
                }
            }
            if (node.n % 10 == 1) {
                int t = (node.n - 1) / 10;
                if (t == A) {
                    System.out.print(node.cnt + 1);
                    return;
                }
                if (t > 0 && !visited.contains(t)) {
                    q.offer(new Node(t, node.cnt + 1));
                    visited.add(t);
                }
            }
        }
        System.out.print(-1);
    }

    static class Node {
        int n;
        int cnt;

        public Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
}
