import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int minus;
    static int zero;
    static int plus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(minus).append("\n").append(zero).append("\n").append(plus);
        System.out.print(sb);
    }

    public static void solve(int r, int c, int size) {
        int num = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != num) {
                    int t = size / 3;
                    solve(r, c, t);
                    solve(r, c + t, t);
                    solve(r, c + 2 * t, t);
                    solve(r + t, c, t);
                    solve(r + t, c + t, t);
                    solve(r + t, c + 2 * t, t);
                    solve(r + 2 * t, c, t);
                    solve(r + 2 * t, c + t, t);
                    solve(r + 2 * t, c + 2 * t, t);
                    return;
                }
            }
        }

        if (arr[r][c] == -1) {
            minus++;
        } else if (arr[r][c] == 0) {
            zero++;
        } else {
            plus++;
        }
    }
}
