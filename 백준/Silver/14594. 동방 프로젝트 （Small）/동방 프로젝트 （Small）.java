import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int len = N + N - 1;
        boolean[] arr = new boolean[len];
        for (int i = 1; i < len; i = i + 2) {
            arr[i] = true;
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int xIdx = 2 * x - 1;
            int yIdx = 2 * (y - 1) - 1;
            for (int j = xIdx; j <= yIdx; j = j + 2) {
                arr[j] = false;
            }
        }

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i]) {
                cnt++;
            }
        }

        System.out.println(cnt + 1);
    }
}