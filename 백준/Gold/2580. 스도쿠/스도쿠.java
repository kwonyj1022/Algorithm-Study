import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int[][] sudoku;
    static boolean[][] row;
    static boolean[][] col;
    static boolean[][] square;
    static List<int[]> blanks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        row = new boolean[9][10];
        col = new boolean[9][10];
        square = new boolean[9][10];
        blanks = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] != 0) {
                    row[i][sudoku[i][j]] = true;
                    col[j][sudoku[i][j]] = true;
                    square[3 * (i / 3) + (j / 3)][sudoku[i][j]] = true;
                } else {
                    blanks.add(new int[]{i, j});
                }
            }
        }

        solve(0);
    }


    static boolean solve(int depth) {
        if (depth == blanks.size()) {
            print();
            return true;
        }

        int[] cur = blanks.get(depth);
        int r = cur[0];
        int c = cur[1];
        int s = 3 * (r / 3) + (c / 3);

        for (int num = 1; num <= 9; num++) {
            if (!row[r][num] && !col[c][num] && !square[s][num]) {
                row[r][num] = col[c][num] = square[s][num] = true;
                sudoku[r][c] = num;

                if (solve(depth + 1)) {
                    return true;
                }

                sudoku[r][c] = 0;
                row[r][num] = col[c][num] = square[s][num] = false;
            }
        }

        return false;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
