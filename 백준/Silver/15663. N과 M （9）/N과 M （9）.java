import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] check;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        check = new boolean[N];
        result = new int[M];
        sb = new StringBuilder();
        solve(0);
        System.out.print(sb);
    }

    static void solve(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < N; i++) {
            if (check[i] || before == arr[i]) {
                continue;
            }
            check[i] = true;
            before = arr[i];
            result[cnt] = arr[i];
            solve(cnt + 1);
            check[i] = false;
        }
    }
}
