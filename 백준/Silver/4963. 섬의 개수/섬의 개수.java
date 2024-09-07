import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dw = {1, -1, 1, -1, 0, 1, -1, 0};
        int[] dh = {0, 0, 1, 1, 1, -1, -1, -1};
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            boolean map[][] = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = st.nextToken().charAt(0) == '1';
                }
            }

            boolean visited[][] = new boolean[h][w];
            Stack<Node> stack = new Stack<>();
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] && !visited[i][j]) {
                        stack.add(new Node(j, i));
                        visited[i][j] = true;
                        while (!stack.isEmpty()) {
                            Node node = stack.pop();
                            for (int k = 0; k < 8; k++) {
                                int th = node.h + dh[k];
                                int tw = node.w + dw[k];
                                if (tw < 0 || tw >= w || th < 0 || th >= h) {
                                    continue;
                                }
                                if (map[th][tw] && !visited[th][tw]) {
                                    stack.add(new Node(tw, th));
                                    visited[th][tw] = true;
                                }
                            }
                        }
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    static class Node {
        int w;
        int h;

        public Node(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }
}
