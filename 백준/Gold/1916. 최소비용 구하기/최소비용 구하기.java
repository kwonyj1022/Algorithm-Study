import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int startNode;
    static int endNode;
    static List<Node>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Node(b, c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        System.out.print(dijkstra(startNode, endNode));
    }

    static long dijkstra(int from, int to) {
        boolean[] visited = new boolean[N + 1];
        long[] cost = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            cost[i] = Long.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.w > o2.w) {
                return 1;
            } else if (o1.w < o2.w) {
                return -1;
            } else {
                return 0;
            }
        });

        pq.offer(new Node(from, 0L));
        cost[from] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.v]) {
                continue;
            }
            visited[current.v] = true;
            for (Node next : map[current.v]) {
                long tmp = cost[current.v] + next.w;
                if (tmp < cost[next.v]) {
                    cost[next.v] = tmp;
                    pq.offer(new Node(next.v, tmp));
                }
            }
        }
        return cost[to];
    }

    static class Node {
        int v;
        long w;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }
}
