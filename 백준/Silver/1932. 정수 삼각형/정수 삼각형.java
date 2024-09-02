import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int size = n * (n + 1) / 2;
        arr = new int[size];
        int t = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                arr[t++] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int target = i * (i + 1) / 2 + j;
                arr[target] = Math.max(get(i - 1, j - 1), get(i - 1, j)) + arr[target];
                max = Math.max(max, arr[target]);
            }
        }
        System.out.print(max);
    }

    static int get(int row, int idx) {
        if (row < 0) {
            return 0;
        }
        if (idx < 0) {
            return 0;
        }
        int range = (row + 1) * (row + 2) / 2 - 1;
        int target = row * (row + 1) / 2 + idx;
        if (target > range) {
            return 0;
        }
        return arr[target];
    }
}
