import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int size;
    static int[][] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        size = N * M;
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    size--;
                }
            }
        }
        size -= 3;
        make(0);
        System.out.print(max);
    }

    static void make(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    make(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    q.offer(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int virus = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            virus++;
            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
                    if (arr[nr][nc] == 0) {
                        q.offer(new Node(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        max = Math.max(max, size - virus);
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
