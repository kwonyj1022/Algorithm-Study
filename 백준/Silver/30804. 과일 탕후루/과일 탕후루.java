import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int[] used = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int t1 = 0;
        int t2 = 0;
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < N; i++) {
            if (used[arr[i]] > -1) {
                used[arr[i]] = i;
                curLen++;
            } else {
                if (used[t1] < used[t2]) {
                    curLen = i - used[t1];
                    used[t1] = -1;
                    t1 = arr[i];
                } else {
                    curLen = i - used[t2];
                    used[t2] = -1;
                    t2 = arr[i];
                }
                used[arr[i]] = i;
            }
            maxLen = Math.max(curLen, maxLen);
        }
        System.out.print(maxLen);
    }
}