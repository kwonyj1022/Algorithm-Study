import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int V;
    static List<Node>[] arr;
    static boolean[] visited;
    static int farNode;
    static int maxLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        arr = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            arr[from] = new ArrayList<>();
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) {
                    break;
                }
                int len = Integer.parseInt(st.nextToken());
                arr[from].add(new Node(to, len));
            }
        }
        visited = new boolean[V + 1];
        findFarNode(1, 0);
        visited = new boolean[V + 1];
        findFarNode(farNode, 0);
        System.out.print(maxLen);
        br.close();
    }

    static void findFarNode(int to, int currentLen) {
        if (currentLen > maxLen) {
            maxLen = currentLen;
            farNode = to;
        }
        visited[to] = true;
        for (int i = 0; i < arr[to].size(); i++) {
            if (!visited[arr[to].get(i).edge]) {
                findFarNode(arr[to].get(i).edge, currentLen + arr[to].get(i).len);
            }
        }
    }

    static class Node {
        int edge;
        int len;

        public Node(int edge, int len) {
            this.edge = edge;
            this.len = len;
        }
    }
}
