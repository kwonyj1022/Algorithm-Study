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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        Queue<Node> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if (str.charAt(j) == 'I') {
                    q.offer(new Node(i, j));
                }
            }
        }
        boolean[][] visited = new boolean[N][M];
        int[] dn = {-1, 1, 0, 0};
        int[] dm = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (arr[poll.n][poll.m] == 'P') {
                cnt++;
            }
            for (int i = 0; i < 4; i++) {
                int nn = poll.n + dn[i];
                int nm = poll.m + dm[i];
                if (nn >= 0 && nn < N && nm >= 0 && nm < M && arr[nn][nm] != 'X' && !visited[nn][nm]) {
                    q.offer(new Node(nn, nm));
                    visited[nn][nm] = true;
                }
            }
        }
        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

    static class Node {
        int n;
        int m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}