import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static int N;
    static boolean[][] map;
    static int[] arr;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new boolean[M][N];
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    map[j][i] = true;
                }
            }
        }
        int cnt = 0;
        arr = new int[M * N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j]) {
                    arr[cnt++] = dfs(i, j, 0);
                }
            }
        }
        Arrays.sort(arr, 0, cnt);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for (int i = 0; i < cnt; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
    }

    static int dfs(int r, int c, int size) {
        if (r < 0 || r >= M || c < 0 || c >= N || map[r][c]) {
            return size;
        }
        map[r][c] = true;
        int newSize = size + 1;
        for (int i = 0; i < 4; i++) {
            newSize += dfs(r + dr[i], c + dc[i], 0);
        }
        return newSize;
    }
}
