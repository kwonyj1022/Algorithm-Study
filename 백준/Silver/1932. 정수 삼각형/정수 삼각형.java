import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Math.max(get(i - 1, j - 1), get(i - 1, j)) + arr[i][j];
                max = Math.max(max, arr[i][j]);
            }
        }
        System.out.print(max);
    }

    static int get(int row, int idx) {
        if (row < 0 || idx < 0 || idx > row) {
            return 0;
        }
        return arr[row][idx];
    }
}
