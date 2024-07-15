import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[N][M];
        Queue<Node> q = new ArrayDeque<>();
        int remain = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int t = Integer.parseInt(st.nextToken());
                if (t == 1) {
                    arr[i][j] = true;
                    q.offer(new Node(i, j, 0));
                    remain++;
                } else if (t == 0) {
                    arr[i][j] = true;
                    remain++;
                }
            }
        }
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        boolean[][] visited = new boolean[N][M];
        int maxday = 0;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (visited[poll.r][poll.c]) {
                continue;
            }
            visited[poll.r][poll.c] = true;
            remain--;
            maxday = Math.max(maxday, poll.day);
            for (int i = 0; i < 4; i++) {
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }
                if (arr[nr][nc] && !visited[nr][nc]) {
                    q.offer(new Node(nr, nc, poll.day + 1));
                }
            }
        }

        if (remain != 0) {
            System.out.println(-1);
        } else {
            System.out.println(maxday);
        }
    }

    static class Node {
        int r;
        int c;
        int day;

        public Node(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }
}
