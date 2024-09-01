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
        q.offer(new Node(A, 1));
        Set<Integer> visited = new HashSet<>();
        visited.add(A);
        while (!q.isEmpty()) {
            Node node = q.poll();
            long t = node.n * 2;
            if (t == B) {
                System.out.print(node.cnt + 1);
                return;
            }
            if (t <= 1000000000 && !visited.contains(t)) {
                q.offer(new Node(t, node.cnt + 1));
                visited.add((int) t);
            }
            t = node.n * 10 + 1;
            if (t == B) {
                System.out.print(node.cnt + 1);
                return;
            }
            if (t <= 1000000000 && !visited.contains(t)) {
                q.offer(new Node(t, node.cnt + 1));
                visited.add((int) t);
            }
        }
        System.out.print(-1);
    }

    static class Node {
        long n;
        int cnt;

        public Node(long n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
}
