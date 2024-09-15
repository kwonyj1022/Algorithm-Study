import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static List<Node>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[100001];
        for (int i = 0; i < 100001; i++) {
            map[i] = new ArrayList<>();
            if (i < 100000) {
                map[i].add(new Node(i + 1, 1));
            }
            if (i > 0) {
                map[i].add(new Node(i - 1, 1));
            }
            if (i <= 50000) {
                map[i].add(new Node(i * 2, 0));
            }
        }

        System.out.print(dijkstra(N, K));
    }

    static int dijkstra(int from, int to) {
        boolean[] visited = new boolean[100001];
        int[] cost = new int[100001];
        for (int i = 0; i < 100001; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

        pq.offer(new Node(from, 0));
        cost[from] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.v]) {
                continue;
            }
            visited[current.v] = true;
            for (Node next : map[current.v]) {
                int tmp = cost[current.v] + next.w;
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
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
