import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n > 1440) {
                System.out.println(-1);
                return;
            }
            if (N == 1) {
                System.out.println(n);
                return;
            }
            arr[i] = n;
        }

        int cnt = 0;
        Arrays.sort(arr);
        while (arr[N - 2] > 0) {
            arr[N - 1] -= 1;
            arr[N - 2] -= 1;
            cnt++;
            Arrays.sort(arr);
        }
        cnt += arr[N - 1];
        
        if (cnt > 1440) {
            cnt = -1;
        }

        System.out.println(cnt);
    }
}