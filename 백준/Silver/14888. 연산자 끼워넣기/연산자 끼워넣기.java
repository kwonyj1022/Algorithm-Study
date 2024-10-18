import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] numbers;
    static int[] op;
    static int max;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        op = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        solve(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int value, int idx) {
        if (idx == N) {
            max = Math.max(value, max);
            min = Math.min(value, min);

            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) {
                continue;
            }
            op[i]--;
            int nextIdx = idx + 1;
            if (i == 0) {
                solve(value + numbers[idx], nextIdx);
            } else if (i == 1) {
                solve(value - numbers[idx], nextIdx);
            } else if (i == 2) {
                solve(value * numbers[idx], nextIdx);
            } else {
                solve(value / numbers[idx], nextIdx);
            }
            op[i]++;
        }
    }
}