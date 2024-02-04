import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int l = 0;
        int r = N - 1;
        int answer = 0;
        while (l < r) {
            int tmp = arr[l] + arr[r];
            if (tmp == M) {
                answer++;
                l++;
                r--;
            } else if (tmp < M) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(answer);
        br.close();
    }
}