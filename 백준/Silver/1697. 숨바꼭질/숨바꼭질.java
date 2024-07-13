import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[100001];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(N, 0));
        while (!q.isEmpty()) {
            Node t = q.poll();
            int time = t.time + 1;
            int nt1 = t.position - 1;
            if (nt1 == K) {
                System.out.println(time);
                return;
            }
            int nt2 = t.position + 1;
            if (nt2 == K) {
                System.out.println(time);
                return;
            }
            int nt3 = 2 * t.position;
            if (nt3 == K) {
                System.out.println(time);
                return;
            }
            if (nt1 >= 0 && nt1 <= 100000 && !visited[nt1]) {
                visited[nt1] = true;
                q.offer(new Node(nt1, time));
            }
            if (nt2 >= 0 && nt2 <= 100000 && !visited[nt2]) {
                visited[nt2] = true;
                q.offer(new Node(nt2, time));
            }
            if (nt3 >= 0 && nt3 <= 100000 && !visited[nt3]) {
                visited[nt3] = true;
                q.offer(new Node(nt3, time));
            }
        }
    }

    static class Node {
        int position;
        int time;

        public Node(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }
}