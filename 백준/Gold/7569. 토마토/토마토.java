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
        int H = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[H][N][M];
        Queue<Node> q = new ArrayDeque<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        q.offer(new Node(i, j, k));
                    }
                }
            }
        }

        int[] dh = {-1, 1, 0, 0, 0, 0};
        int[] dn = {0, 0, -1, 1, 0, 0};
        int[] dm = {0, 0, 0, 0, -1, 1};

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 6; i++) {
                int th = node.h + dh[i];
                int tn = node.n + dn[i];
                int tm = node.m + dm[i];

                if (th >= 0 && th < H && tn >= 0 && tn < N && tm >= 0 && tm < M && arr[th][tn][tm] == 0) {
                    arr[th][tn][tm] = arr[node.h][node.n][node.m] + 1;
                    q.offer(new Node(th, tn, tm));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.print(-1);
                        return;
                    }
                    max = Math.max(max, arr[i][j][k]);
                }
            }
        }

        if (max == 1) {
            System.out.print(0);
        } else {
            System.out.print(max - 1);
        }
    }

    static class Node {
        int h;
        int n;
        int m;

        public Node (int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }
}