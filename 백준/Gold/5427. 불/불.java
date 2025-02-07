import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w, h, sw, sh;
    static char[][] map;
    static boolean[][] visited;
    static int[] dw, dh;
    static Queue<int[]> fires;
    static Queue<int[]> queue;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        dw = new int[]{-1, 1, 0, 0};
        dh = new int[]{0, 0, -1, 1};
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            visited = new boolean[h][w];
            fires = new ArrayDeque<>();
            queue = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '@') {
                        sw = j;
                        sh = i;
                    }
                    if (map[i][j] == '*') {
                        fires.offer(new int[]{i, j});
                    }
                }
            }
            solve();
        }
        System.out.print(sb);
    }

    static void solve() {
        queue.offer(new int[]{sh, sw});
        visited[sh][sw] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int fireCnt = fires.size();
            while (fireCnt-- > 0) {
                int[] fire = fires.poll();
                for (int i = 0; i < 4; i++) {
                    int nfh = fire[0] + dh[i];
                    int nfw = fire[1] + dw[i];
                    if (nfh >= 0 && nfw >= 0 && nfh < h && nfw < w && map[nfh][nfw] != '#' && map[nfh][nfw] != '*') {
                        map[nfh][nfw] = '*';
                        fires.offer(new int[]{nfh, nfw});
                    }
                }
            }

            int levelCnt = queue.size();
            while (levelCnt-- > 0) {
                int[] cur = queue.poll();
                if (cur[0] == 0 || cur[1] == 0 || cur[0] == h - 1 || cur[1] == w - 1) {
                    sb.append(cnt + 1).append("\n");
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int nh = cur[0] + dh[i];
                    int nw = cur[1] + dw[i];
                    if (nh >= 0 && nw >= 0 && nh < h && nw < w && !visited[nh][nw] && map[nh][nw] != '#' && map[nh][nw] != '*') {
                        visited[nh][nw] = true;
                        queue.offer(new int[]{nh, nw});
                    }
                }
            }
            cnt++;
        }

        sb.append("IMPOSSIBLE").append("\n");
    }
}
