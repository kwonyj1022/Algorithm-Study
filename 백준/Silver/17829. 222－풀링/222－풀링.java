import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        tmp = new int[4];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solve(N));
    }

    static int solve(int n) {
        if (n == 1) {
            return arr[0][0];
        }
        int half = n / 2;
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                int di = i * 2;
                int dj = j * 2;
                arr[i][j] = getSecondMax(arr[di][dj], arr[di + 1][dj], arr[di][dj + 1], arr[di + 1][dj + 1]);
            }
        }
        return solve(half);
    }

    static int getSecondMax(int a, int b, int c, int d) {
        tmp[0] = a;
        tmp[1] = b;
        tmp[2] = c;
        tmp[3] = d;
        Arrays.sort(tmp);
        return tmp[2];
    }
}