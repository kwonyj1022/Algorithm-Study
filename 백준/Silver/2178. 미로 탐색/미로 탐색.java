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
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int targetN = N - 1;
        int targetM = M - 1;
        int[] dn = {0, 0, -1, 1};
        int[] dm = {-1, 1, 0, 0};
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 1));
        map[0][0] = '2';
        while (!q.isEmpty()) {
            Node node = q.poll();
            int tcnt = node.cnt + 1;
            for (int i = 0; i < 4; i++) {
                int tn = node.n + dn[i];
                int tm = node.m + dm[i];
                if (tn == targetN && tm == targetM) {
                    System.out.print(tcnt);
                    return;
                }
                if (tn >= 0 && tn < N && tm >= 0 && tm < M && map[tn][tm] == '1') {
                    q.add(new Node(tn, tm, tcnt));
                    map[tn][tm] = '2';
                }
            }
        }
    }

    static class Node {
        int n;
        int m;
        int cnt;

        public Node(int n, int m, int cnt) {
            this.n = n;
            this.m = m;
            this.cnt = cnt;
        }
    }
}