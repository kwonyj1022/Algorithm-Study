import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int E;
    static List<Node>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Node(b, c));
            map[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int pathUV = dijkstra(u, v);
        if (pathUV == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }

        int path1U = dijkstra(1, u);
        int pathUN = dijkstra(u, N);
        int path1V = dijkstra(1, v);
        int pathVN = dijkstra(v, N);

        int path1 = Integer.MAX_VALUE;
        if (path1V != Integer.MAX_VALUE && pathUN != Integer.MAX_VALUE) {
            path1 = path1V + pathUV + pathUN;
        }
        int path2 = Integer.MAX_VALUE;
        if (path1U != Integer.MAX_VALUE && pathVN != Integer.MAX_VALUE) {
            path2 = path1U + pathUV + pathVN;
        }

        int answer = Math.min(path1, path2);
        if (answer == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.println(answer);
        }
    }

    static int dijkstra(int from, int to) {
        boolean[] visited = new boolean[N + 1];
        int[] pathLen = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            pathLen[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Node(from, 0));
        pathLen[from] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.v]) {
                continue;
            }
            visited[current.v] = true;
            for (Node next : map[current.v]) {
                int tmp = pathLen[current.v] + next.w;
                if (tmp < pathLen[next.v]) {
                    pathLen[next.v] = tmp;
                    pq.offer(new Node(next.v, tmp));
                }
            }
        }
        return pathLen[to];
    }

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
