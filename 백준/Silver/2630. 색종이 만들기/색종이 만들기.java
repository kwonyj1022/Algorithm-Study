import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static boolean[][] arr;
    private static int wcnt = 0;
    private static int bcnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    arr[i][j] = true;
                }
            }
        }

        solve(0, 0, N);
        System.out.println(wcnt);
        System.out.println(bcnt);
    }

    private static void solve(int x, int y, int size) {
        if (x > N || y > N) {
            return;
        }
        if (size == 1) {
            if (arr[x][y]) {
                bcnt++;
            } else {
                wcnt++;
            }
            return;
        }

        int xend = x + size;
        int yend = y + size;
        boolean color = arr[x][y];
        for (int i = x; i < xend; i++) {
            for (int j = y; j < yend; j++) {
                if (arr[i][j] != color) {
                    int newSize = size / 2;
                    solve(x, y, newSize);
                    solve(x + newSize, y, newSize);
                    solve(x, y + newSize, newSize);
                    solve(x + newSize, y + newSize, newSize);
                    return;
                }
            }
        }
        if (arr[x][y]) {
            bcnt++;
        } else {
            wcnt++;
        }

    }
}