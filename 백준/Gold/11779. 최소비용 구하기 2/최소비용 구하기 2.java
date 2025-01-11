import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
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
            map[from].add(new Node(to, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] previous = new int[n + 1];

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(start, 0));
        minCost[start] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.n == end) {
                Stack<Integer> path = new Stack<>();
                int last = end;
                while (last != start) {
                    path.add(last);
                    last = previous[last];
                }
                path.add(start);

                StringBuilder sb = new StringBuilder();
                sb.append(current.cost).append("\n");
                sb.append(path.size()).append("\n");
                while (!path.isEmpty()) {
                    sb.append(path.pop()).append(" ");
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
                    Node newNode = new Node(next.n, nextCost);
                    pq.offer(newNode);
                    previous[next.n] = current.n;
                }
            }
        }
    }

    static class Node {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}
