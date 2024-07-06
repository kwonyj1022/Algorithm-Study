import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int arr[][] = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[b][a] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 1) {
                        continue;
                    }
                    Queue<Node> q = new ArrayDeque<>();
                    q.offer(new Node(i, j));
                    arr[i][j] = 2;
                    cnt++;
                    while (!q.isEmpty()) {
                        Node poll = q.poll();
                        int x = poll.x;
                        int y = poll.y;
                        if (x > 0 && arr[x-1][y] == 1) {
                            arr[x-1][y] = 2;
                            q.offer(new Node(x-1, y));
                        }
                        if (y > 0 && arr[x][y-1] == 1) {
                            arr[x][y-1] = 2;
                            q.offer(new Node(x, y-1));
                        }
                        if (x < N-1 && arr[x+1][y] == 1) {
                            arr[x+1][y] = 2;
                            q.offer(new Node(x+1, y));
                        }
                        if (y < M-1 && arr[x][y+1] == 1) {
                            arr[x][y+1] = 2;
                            q.offer(new Node(x, y+1));
                        }
                    }
                }
            }

            System.out.println(cnt);
        }
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