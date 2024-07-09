import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static boolean[][] arr;
    private static boolean[] visited;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }

        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cnt++;
                bfs(i);
            }
        }

        System.out.println(cnt);
    }

    private static void bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[x] = true;
        q.offer(x);
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && arr[poll][i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}