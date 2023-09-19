import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int modCnt = 0;
        int[] arr = new int[N];
        int[] cnt = new int[8001];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            cnt[n + 4000] += 1;
            sum += n;
            if (cnt[n + 4000] > modCnt) {
                modCnt++;
            }
        }
        Arrays.sort(arr, 0, N);

        System.out.println(Math.round(sum / (double) N));
        System.out.println(arr[N / 2]);
        System.out.println(findMod(cnt, modCnt));
        System.out.println(arr[N -1] - arr[0]);
    }

    private static int findMod(final int[] cnt, final int modCnt) {
        int i = 0;
        int n = 0;
        int answer = 0;
        while (n < 2 && i < 8001) {
            if (cnt[i] == modCnt) {
                answer = i - 4000;
                n++;
            }
            i++;
        }
        return answer;
    }
}