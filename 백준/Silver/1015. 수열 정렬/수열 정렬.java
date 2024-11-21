import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node[] nodes = new Node[N];
        Node[] copy = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(Integer.parseInt(st.nextToken()));
            copy[i] = nodes[i];
        }
        Arrays.sort(copy, (o1, o2) -> o1.x - o2.x);
        for (int i = 0; i < N; i++) {
            copy[i].p = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(nodes[i].p).append(" ");
        }
        System.out.print(sb);
    }

    static class Node {
        int x;
        int p;

        public Node(int x) {
            this.x = x;
        }
    }
}
