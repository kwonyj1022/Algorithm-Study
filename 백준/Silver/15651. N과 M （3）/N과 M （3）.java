import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int cursor;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        cursor = -1;
        arr = new int[M];
        sb = new StringBuilder();
        solve(0, 1);
        System.out.println(sb);
    }

    static void solve(int n, int next) {
        if (n == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            cursor++;
            arr[cursor] = i;
            solve(n + 1, i);
            cursor--;
        }
    }
}
