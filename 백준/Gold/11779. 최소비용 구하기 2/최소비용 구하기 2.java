import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Node>[] map = new ArrayList[n + 1];
        int[] minCost = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
            minCost[i] = 100000000;
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[from].add(new Node(to, cost, new ArrayList<>()));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(start, 0, new ArrayList<>()));
        minCost[start] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.n == end) {
                StringBuilder sb = new StringBuilder();
                sb.append(current.cost).append("\n").append(current.path.size()).append("\n");
                for (int pathNode : current.path) {
                    sb.append(pathNode).append(" ");
                }
                System.out.print(sb);
                return;
            }
            if (visited[current.n]) {
                continue;
            }
            visited[current.n] = true;
            for (Node next : map[current.n]) {
                int nextCost = minCost[current.n] + next.cost;
                if (minCost[next.n] > nextCost) {
                    minCost[next.n] = nextCost;
                    Node newNode = new Node(next.n, nextCost, current.path);
                    pq.offer(newNode);
                }
            }
        }
    }

    static class Node {
        int n;
        int cost;
        List<Integer> path;

        public Node(int n, int cost, List<Integer> prePath) {
            this.n = n;
            this.cost = cost;
            this.path = new ArrayList(prePath);
            this.path.add(n);
        }
    }
}
