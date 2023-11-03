import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] result = new int[N + 1][2];
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                result[i][0] = Integer.parseInt(st.nextToken());
                result[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(result, (o1, o2) -> o1[0] - o2[0]);
            int[] d = new int[N + 1];
            d[1] = 100001;
            int min = 100001;
            for (int i = 1; i < N; i++) {
                if (result[i][1] < min) {
                    min = result[i][1];
                }
                d[i + 1] = min;
            }

            int answer = N;
            for (int i = 1; i <= N; i++) {
                if (d[i] < result[i][1]) {
                    answer--;
                }
            }

            System.out.println(answer);
        }
    }
}