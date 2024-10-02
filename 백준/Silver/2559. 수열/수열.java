import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] hap = new int[N];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        hap[0] = arr[0];
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hap[i] = hap[i - 1] + arr[i];
        }
        int max = hap[K - 1];
        for (int i = K; i < N; i++) {
            max = Math.max(max, hap[i] - hap[i - K]);
        }
        System.out.print(max);
    }
}
