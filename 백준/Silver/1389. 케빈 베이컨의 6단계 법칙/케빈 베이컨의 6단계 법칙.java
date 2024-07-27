import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static boolean[][] map;
    static boolean[] visited;
    static int[] bacon;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }
        bacon = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            solve(i);
        }

        int minBacon = Integer.MAX_VALUE;
        int answer = 1;
        for (int i = 1; i <= N; i++) {
            if (bacon[i] < minBacon) {
                minBacon = bacon[i];
                answer = i;
            }
        }

        System.out.print(answer);
    }

    static void solve(int user) {
        visited = new boolean[N + 1];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(user, 0));
        visited[user] = true;
        int total = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int tcnt = node.cnt + 1;
            for (int i = 1; i <= N; i++) {
                if (map[node.n][i] && !visited[i]) {
                    q.offer(new Node(i, tcnt));
                    visited[i] = true;
                    total += tcnt;
                }
            }
        }
        bacon[user] = total;
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