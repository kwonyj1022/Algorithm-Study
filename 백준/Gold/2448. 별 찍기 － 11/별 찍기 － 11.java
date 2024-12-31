import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int col = N * 2 - 1;
        arr = new char[N][col];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = ' ';
            }
        }
        sb = new StringBuilder();
        star(0, 0, N);
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void star(int r, int c, int n) {
        if (n == 3) {
            arr[r][c + 2] = '*';
            r++;
            arr[r][c + 1] = '*';
            arr[r][c + 3] = '*';
            r++;
            for (int i = 0; i < 5; i++) {
                arr[r][c++] = '*';
            }
            return;
        }
        int halfN = n / 2;
        star(r, c + halfN, halfN);
        r += halfN;
        star(r, c, halfN);
        star(r, c + n, halfN);
    }
}
