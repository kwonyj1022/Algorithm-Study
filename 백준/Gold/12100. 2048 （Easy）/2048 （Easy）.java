import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        solve(0);
        System.out.print(answer);
    }

    static void solve(int tryCnt) {
        if (tryCnt == 5) {
            answer = Math.max(answer, findMax());
            return;
        }
        int[][] tmp = copy(board);
        int next = tryCnt + 1;
        left();
        solve(next);
        board = copy(tmp);
        right();
        solve(next);
        board = copy(tmp);
        up();
        solve(next);
        board = copy(tmp);
        down();
        solve(next);
        board = copy(tmp);
    }

    static int findMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(board[i][j], max);
            }
        }
        return max;
    }

    static int[][] copy(int[][] target) {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(target[i], 0, copy[i], 0, N);
        }
        return copy;
    }

    static void left() {
        for (int i = 0; i < N; i++) {
            int pos = 0;
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    board[i][pos] = board[i][j];
                    if (pos != j) {
                        board[i][j] = 0;
                    }
                    pos++;
                }
            }
            pos = 0;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == 0) {
                    break;
                }
                if (board[i][j] == board[i][j + 1]) {
                    board[i][pos++] = board[i][j] * 2;
                    board[i][j + 1] = 0;
                    j++;
                } else {
                    board[i][pos] = board[i][j];
                    if (pos != j) {
                        board[i][j] = 0;
                    }
                    pos++;
                }
            }
            if (pos < N) {
                board[i][pos] = board[i][N - 1];
                while (++pos < N) {
                    board[i][pos] = 0;
                }
            }
        }
    }

    static void right() {
        for (int i = 0; i < N; i++) {
            int pos = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (board[i][j] != 0) {
                    board[i][pos] = board[i][j];
                    if (pos != j) {
                        board[i][j] = 0;
                    }
                    pos--;
                }
            }
            pos = N - 1;
            for (int j = N - 1; j > 0; j--) {
                if (board[i][j] == 0) {
                    break;
                }
                if (board[i][j] == board[i][j - 1]) {
                    board[i][pos--] = board[i][j] * 2;
                    board[i][j - 1] = 0;
                    j--;
                } else {
                    board[i][pos] = board[i][j];
                    if (pos != j) {
                        board[i][j] = 0;
                    }
                    pos--;
                }
            }
            if (pos >= 0) {
                board[i][pos] = board[i][0];
                while (--pos >= 0) {
                    board[i][pos] = 0;
                }
            }
        }
    }

    static void up() {
        for (int j = 0; j < N; j++) {
            int pos = 0;
            for (int i = 0; i < N; i++) {
                if (board[i][j] != 0) {
                    board[pos][j] = board[i][j];
                    if (pos != i) {
                        board[i][j] = 0;
                    }
                    pos++;
                }
            }
            pos = 0;
            for (int i = 0; i < N - 1; i++) {
                if (board[i][j] == 0) {
                    break;
                }
                if (board[i][j] == board[i + 1][j]) {
                    board[pos++][j] = board[i][j] * 2;
                    board[i + 1][j] = 0;
                    i++;
                } else {
                    board[pos][j] = board[i][j];
                    if (pos != i) {
                        board[i][j] = 0;
                    }
                    pos++;
                }
            }
            if (pos < N) {
                board[pos][j] = board[N - 1][j];
                while (++pos < N) {
                    board[pos][j] = 0;
                }
            }
        }
    }

    static void down() {
        for (int j = N - 1; j >= 0; j--) {
            int pos = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    board[pos][j] = board[i][j];
                    if (pos != i) {
                        board[i][j] = 0;
                    }
                    pos--;
                }
            }
            pos = N - 1;
            for (int i = N - 1; i > 0; i--) {
                if (board[i][j] == 0) {
                    break;
                }
                if (board[i][j] == board[i - 1][j]) {
                    board[pos--][j] = board[i][j] * 2;
                    board[i - 1][j] = 0;
                    i--;
                } else {
                    board[pos][j] = board[i][j];
                    if (pos != i) {
                        board[i][j] = 0;
                    }
                    pos--;
                }
            }
            if (pos >= 0) {
                board[pos][j] = board[0][j];
                for (int i = pos - 1; i >= 0; i--) {
                    while (--pos >= 0) {
                        board[pos][j] = 0;
                    }
                }
            }
        }
    }
}
