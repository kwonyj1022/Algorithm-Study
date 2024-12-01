import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[][] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        solve(0);
        System.out.print(answer);
    }

    static void solve(int r) {
        if (r == N) {
            answer++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (isPossible(r, c)) {
                board[r][c] = true;
                solve(r + 1);
                board[r][c] = false;
            }
        }
    }

    static boolean isPossible(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (board[i][c]) {
                return false;
            }
        }

        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        for (int i = r - 1, j = c + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }
}
