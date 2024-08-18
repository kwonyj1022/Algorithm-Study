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
        int[] board = new int[101];
        for (int i = 1; i < 101; i++) {
            board[i] = i;
        }
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        int[] visited = new int[101];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 1; i <= 6; i++) {
                int t = node + i;
                if (t > 100 || visited[board[t]] != 0) {
                    continue;
                }
                if (board[t] == 100) {
                    System.out.print(visited[node] + 1);
                    return;
                }
                visited[board[t]] = visited[node] + 1;
                q.offer(board[t]);
            }
        }
    }
}
