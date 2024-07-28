import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int[][] map;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = dfs(i, j, 0);
                if (cnt != 0) {
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.print(sb);
    }

    static int dfs(int r, int c, int cnt) {
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return cnt;
        }
        if (map[r][c] != '1') {
            return cnt;
        }
        map[r][c] = '2';
        cnt++;
        cnt = dfs(r, c + 1, cnt);
        cnt = dfs(r, c - 1,  cnt);
        cnt = dfs(r + 1, c, cnt);
        cnt = dfs(r - 1, c, cnt);
        return cnt;
    }
}