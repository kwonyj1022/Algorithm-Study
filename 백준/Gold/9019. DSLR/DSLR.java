import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Queue<Node> q = new ArrayDeque<>();
            boolean[] visited = new boolean[10001];
            q.offer(new Node(A, ""));
            visited[A] = true;
            while (!q.isEmpty()) {
                Node node = q.poll();
                Node dNode = d(node);
                if (dNode.n == B) {
                    sb.append(dNode.command).append("\n");
                    break;
                } else if (!visited[dNode.n]) {
                    q.offer(dNode);
                    visited[dNode.n]= true;
                }
                Node sNode = s(node);
                if (sNode.n == B) {
                    sb.append(sNode.command).append("\n");
                    break;
                } else if (!visited[sNode.n]) {
                    q.offer(sNode);
                    visited[sNode.n] = true;
                }
                Node lNode = l(node);
                if (lNode.n == B) {
                    sb.append(lNode.command).append("\n");
                    break;
                } else if (!visited[lNode.n]) {
                    q.offer(lNode);
                    visited[lNode.n] = true;
                }
                Node rNode = r(node);
                if (rNode.n == B) {
                    sb.append(rNode.command).append("\n");
                    break;
                } else if (!visited[rNode.n]){
                    q.offer(rNode);
                    visited[rNode.n] = true;
                }
            }
        }
        System.out.print(sb);
    }

    static Node d(Node node) {
        return new Node(2 * node.n % 10000, node.command + "D");
    }

    static Node s(Node node) {
        if (node.n == 0) {
            return new Node(9999, node.command + "S");
        }
        return new Node(node.n - 1, node.command + "S");
    }

    static Node l(Node node) {
        int n = node.n % 1000 * 10 + node.n / 1000;
        return new Node(n, node.command + "L");
    }

    static Node r(Node node) {
        int d4 = node.n % 10;
        int n = (node.n - d4) / 10 + d4 * 1000;
        return new Node(n, node.command + "R");
    }

    static class Node {
        int n;
        String command;

        public Node(int n, String command) {
            this.n = n;
            this.command = command;
        }
    }
}
