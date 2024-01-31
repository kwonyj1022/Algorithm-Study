import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N + 1];
        int cnt[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken())) % M;
            cnt[arr[i]]++;
        }

        long answer = cnt[0];
        for (int i = 0; i < M; i++) {
            answer += (long) cnt[i] * (cnt[i] - 1) / 2;
        }

        System.out.println(answer);
    }
}