import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int K;
    static char[][] board;
    static char[][] mask;
    static int[][] sum1;
    static int[][] sum2;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMK = br.readLine().split(" ");
        N = Integer.parseInt(NMK[0]);
        M = Integer.parseInt(NMK[1]);
        K = Integer.parseInt(NMK[2]);
        board = new char[N][M];
        mask = new char[N + 1][M];
        sum1 = new int[N + 1][M + 1];
        sum2 = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i <= N; i+=2) {
            boolean isB = true;
            for (int j = 0; j < M; j++) {
                mask[i][j] = isB ? 'B' : 'W';
                isB = !isB;
            }
        }
        for (int i = 1; i <= N; i+=2) {
            boolean isB = false;
            for (int j = 0; j < M; j++) {
                mask[i][j] = isB ? 'B' : 'W';
                isB = !isB;
            }
        }

        for (int i = 0; i < N; i++) {
            sum1[i + 1][0] = sum1[i][0];
            sum2[i + 1][0] = sum2[i][0];
            for (int j = 0; j < M; j++) {
                sum1[i + 1][j + 1] = sum1[i + 1][j] + sum1[i][j + 1] - sum1[i][j];
                sum2[i + 1][j + 1] = sum2[i + 1][j] + sum2[i][j + 1] - sum2[i][j];
                if (board[i][j] != mask[i][j]) {
                    sum1[i + 1][j + 1]++;
                }
                if (board[i][j] != mask[i + 1][j]) {
                    sum2[i + 1][j + 1]++;
                }
            }
        }

        answer = Integer.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int tmp1 = sum1[i][j] - sum1[i - K][j] - sum1[i][j - K] + sum1[i - K][j - K];
                int tmp2 = sum2[i][j] - sum2[i - K][j] - sum2[i][j - K] + sum2[i - K][j - K];
                answer = Math.min(answer, Math.min(tmp1, tmp2));
            }
        }
        System.out.print(answer);
    }

    static int solve(int r, int c) {
        int t1 = 0;
        for (int ir = r, im = 0; ir < r + K; ir++, im++) {
            for (int jc = c, jm = 0; jc < c + K; jc++, jm++) {
                if (board[ir][jc] != mask[im][jm]) {
                    t1++;
                }
            }
        }
        int t2 = 0;
        for (int ir = r, im = 1; ir < r + K; ir++, im++) {
            for (int jc = c, jm = 0; jc < c + K; jc++, jm++) {
                if (board[ir][jc] != mask[im][jm]) {
                    t2++;
                }
            }
        }
        return Math.min(t1, t2);
    }
}
