import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            d[i][0] = i;
            d[i][1] = Integer.parseInt(st.nextToken());
            d[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(d, (o1, o2) -> o1[1] - o2[1]);
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            if(i == N - 1) {
                answer[d[i][0]] = 1;
            }
            for (int j = i + 1; j < N; j++) {
                if (d[i][1] == d[j][1]) {
                    continue;
                }
                if (d[i][2] < d[j][2]) {
                    cnt++;
                }
            }
            answer[d[i][0]] = cnt + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}