import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n][m];
        int[][] distance = new int[n][m];
        int r = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int t = Integer.parseInt(st.nextToken());
                if (t == 2) {
                    r = i;
                    c = j;
                    arr[i][j] = true;
                } else if (t == 1) {
                    arr[i][j] = true;
                    distance[i][j] = -1;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(r, c));
        visited[r][c] = true;
        distance[r][c] = 0;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            Node poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int tr = poll.r + dr[i];
                int tc = poll.c + dc[i];
                if (tr >= 0 && tr < n && tc >= 0 && tc < m && !visited[tr][tc] && arr[tr][tc]) {
                    q.offer(new Node(tr, tc));
                    visited[tr][tc] = true;
                    distance[tr][tc] = distance[poll.r][poll.c] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(String.format("%d ", distance[i][j]));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}