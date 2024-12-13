import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static int K;
    static char[][] map;
    static int answer = 0;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            map[i] = row.toCharArray();
        }
        dfs(R - 1, 0, 1);
        System.out.print(answer);
    }

    static void dfs(int r, int c, int depth) {
        if (depth == K) {
            if (r == 0 && c == C - 1) {
                answer++;
            }
            return;
        }
        if (r == 0 && c == C - 1) {
            return;
        }
        map[r][c] = 'v';
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 'T' || map[nr][nc] == 'v') {
                continue;
            }
            dfs(nr, nc, depth + 1);
        }
        map[r][c] = '.';
    }
}
