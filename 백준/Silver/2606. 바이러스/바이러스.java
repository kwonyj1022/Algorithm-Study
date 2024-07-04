import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n + 1][n + 1];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int cnt = 0;

        visited[1] = true;
        q.offer(1);
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int i = 0; i <= n; i++) {
                if (arr[poll][i] && !visited[i]) {
                    visited[i] = true;
                    cnt++;
                    q.offer(i);
                }
            }
        }

        System.out.println(cnt);
    }
}