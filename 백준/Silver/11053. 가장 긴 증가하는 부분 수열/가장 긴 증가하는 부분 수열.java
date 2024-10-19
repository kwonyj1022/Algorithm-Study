import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] cnt = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    tmp = Math.max(tmp, cnt[j]);
                }
            }
            cnt[i] = tmp + 1;
            max = Math.max(max, cnt[i]);
        }
        System.out.print(max);
    }
}
