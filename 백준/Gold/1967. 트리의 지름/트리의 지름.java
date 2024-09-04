import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<Node>[] arr;
    static boolean[] visited;
    static int farNode;
    static int maxLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            arr[from].add(new Node(to, len));
            arr[to].add(new Node(from, len));
        }
        visited = new boolean[n + 1];
        findFarNode(1, 0);
        visited = new boolean[n + 1];
        findFarNode(farNode, 0);
        System.out.print(maxLen);
        br.close();
    }

    static void findFarNode(int from, int currentLen) {
        if (currentLen > maxLen) {
            maxLen = currentLen;
            farNode = from;
        }
        visited[from] = true;
        if (arr[from] == null) {
            return;
        }
        for (int i = 0; i < arr[from].size(); i++) {
            if (!visited[arr[from].get(i).edge]) {
                findFarNode(arr[from].get(i).edge, currentLen + arr[from].get(i).len);
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
