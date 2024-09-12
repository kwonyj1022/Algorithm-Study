import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Node>[] map = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[u].add(new Node(v, w));
        }

        int[] pathLen = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            pathLen[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Node(K, 0));
        pathLen[K] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.w > pathLen[current.v]) continue;
            for (Node next : map[current.v]) {
                int tmp = pathLen[current.v] + next.w;
                if (tmp < pathLen[next.v]) {
                    pathLen[next.v] = tmp;
                    pq.offer(new Node(next.v, tmp));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (pathLen[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(pathLen[i]).append("\n");
            }
        }
        System.out.print(sb);
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
