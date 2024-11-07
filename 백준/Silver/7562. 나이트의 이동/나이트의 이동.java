import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int I = Integer.parseInt(br.readLine());
            visited = new int[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            Queue<Node> q = new ArrayDeque<>();
            q.offer(new Node(fx, fy));
            visited[fx][fy] = 1;
            while (!q.isEmpty()) {
                Node node = q.poll();
                if (node.x == tx && node.y == ty) {
                    break;
                }
                for (int i = 0; i < 8; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if (nx >= 0 && nx < I && ny >= 0 && ny < I && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[node.x][node.y] + 1;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
            sb.append(visited[tx][ty] - 1).append("\n");
        }
        System.out.println(sb);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}