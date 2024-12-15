import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println("Hing");
    }

    private static void dfs(int r, int c) {
        if (arr[r][c] == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for (int i = 0; i < 2; i++) {
            int x = r + dx[i] * arr[r][c];
            int y = c + dy[i] * arr[r][c];
            if (x >= N || y >= N || visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            dfs(x, y);
        }
    }
}
