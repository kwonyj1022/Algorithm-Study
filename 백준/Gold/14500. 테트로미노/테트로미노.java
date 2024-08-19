import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                run(i, j);
            }
        }

        System.out.print(max);
    }

    static void run(int r, int c) {
        process(r, c, r, c + 1, r, c + 2, r, c + 3);
        process(r, c, r + 1, c, r + 2, c, r + 3, c);
        process(r, c, r + 1, c, r, c - 1, r, c - 2);
        process(r, c, r + 1, c, r, c + 1, r, c + 2);
        process(r, c, r - 1, c, r, c + 1, r, c + 2);
        process(r, c, r - 1, c, r, c - 1, r, c - 2);
        process(r, c, r, c + 1, r + 1, c, r + 2, c);
        process(r, c, r, c - 1, r + 1, c, r + 2, c);
        process(r, c, r, c + 1, r - 1, c, r - 2, c);
        process(r, c, r, c - 1, r - 1, c, r - 2, c);
        process(r, c, r - 1, c, r, c + 1, r + 1, c + 1);
        process(r, c, r, c - 1, r - 1, c, r - 1, c + 1);
        process(r, c, r + 1, c, r, c + 1, r - 1, c + 1);
        process(r, c, r, c - 1, r + 1, c, r + 1, c + 1);
        process(r, c, r, c - 1, r, c + 1, r - 1, c);
        process(r, c, r, c + 1, r - 1, c, r + 1, c);
        process(r, c, r, c - 1, r, c + 1, r + 1, c);
        process(r, c, r, c - 1, r - 1, c, r + 1, c);
        process(r, c, r, c + 1, r + 1, c, r + 1, c + 1);
    }

    static void process(int r1, int c1, int r2, int c2, int r3, int c3, int r4, int c4) {
        if (validate(r1, c1) && validate(r2, c2) && validate(r3, c3) && validate(r4, c4)) {
            max = Math.max(max, arr[r1][c1] + arr[r2][c2] + arr[r3][c3] + arr[r4][c4]);
        }
    }

    static boolean validate(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
