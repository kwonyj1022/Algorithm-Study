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
    static int X;
    static List<Node>[] mapFrom;
    static List<Node>[] mapTo;
    static int[] from;
    static int[] to;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        mapFrom = new ArrayList[N + 1];
        mapTo = new ArrayList[N + 1];
        from = new int[N + 1];
        to = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            mapFrom[i] = new ArrayList<>();
            mapTo[i] = new ArrayList<>();
            from[i] = Integer.MAX_VALUE;
            to[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            mapFrom[a].add(new Node(b, t));
            mapTo[b].add(new Node(a, t));
        }

        getFrom();
        getTo();

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, from[i] + to[i]);
        }
        System.out.print(max);
    }

    static class Node {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }

    static void getFrom() {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(X, 0));
        from[X] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.n]) {
                continue;
            }
            visited[current.n] = true;
            for (Node pre : mapTo[current.n]) {
                if (from[pre.n] > from[current.n] + pre.cost) {
                    from[pre.n] = from[current.n] + pre.cost;
                    pq.offer(new Node(pre.n, from[pre.n]));
                }
            }
        }
    }

    static void getTo() {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(X, 0));
        to[X] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.n]) {
                continue;
            }
            visited[current.n] = true;
            for (Node next: mapFrom[current.n]) {
                if (to[next.n] > to[current.n] + next.cost) {
                    to[next.n] = to[current.n] + next.cost;
                    pq.offer(new Node(next.n, to[next.n]));
                }
            }
        }
    }
}
