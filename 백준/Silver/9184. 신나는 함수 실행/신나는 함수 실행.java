import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][][] w = new int[21][21][21];
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                w[0][i][j] = 1;
                w[i][0][j] = 1;
                w[i][j][0] = 1;
            }
        }

        for (int a = 1; a <= 20; a++) {
            for (int b = 1; b <= 20; b++) {
                for (int c = 1; c <= 20; c++) {
                    if (a < b && b < c) {
                        w[a][b][c] = w[a][b][c - 1] + w[a][b - 1][c - 1] - w[a][b - 1][c];
                    } else {
                        w[a][b][c] = w[a - 1][b][c] + w[a - 1][b - 1][c] + w[a - 1][b][c - 1] - w[a - 1][b - 1][c - 1];
                    }
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                return;
            }
            int answer;
            if (a <= 0 || b <= 0 || c <= 0) {
                answer = 1;
            } else if (a > 20 || b > 20 || c > 20) {
                answer = w[20][20][20];
            } else {
                answer = w[a][b][c];
            }
            System.out.printf("w(%d, %d, %d) = %d%n", a, b, c, answer);
        }
    }
}