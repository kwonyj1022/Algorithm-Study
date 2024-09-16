import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.print(bfs(N, K));
    }

    static int bfs(int from, int to) {
        Deque<Node> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        dq.addLast(new Node(from, 0));
        visited[from] = true;
        while (!dq.isEmpty()) {
            Node node = dq.pollFirst();
            if (node.x == K) {
                return node.sec;
            }
            visited[node.x] = true;
            int forward = node.x + 1;
            int backward = node.x - 1;
            int teleport = node.x * 2;

            if (0 <= forward && forward < 100001 && !visited[forward]) {
                dq.addLast(new Node(forward, node.sec + 1));
            }
            if (0 <= backward && backward < 100001 && !visited[backward]) {
                dq.addLast(new Node(backward, node.sec + 1));
            }
            if (0 <= teleport && teleport < 100001 && !visited[teleport]) {
                dq.addFirst(new Node(teleport, node.sec));
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int sec;

        public Node(int x, int sec) {
            this.x = x;
            this.sec = sec;
        }
    }
}