import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int a = 0;
            int b = N - 1;
            while (a < b) {
                if (a == i) {
                    a++;
                    continue;
                } else if (b == i) {
                    b--;
                    continue;
                }
                int t = arr[a] + arr[b];
                if (t < target) {
                    a++;
                } else if (t > target) {
                    b--;
                } else {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}