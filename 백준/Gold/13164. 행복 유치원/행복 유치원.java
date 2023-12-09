import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] h = new int[N];
        Integer[] d = new Integer[N];
        d[0] = 1000000000;
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
            if (i != 0) {
                d[i] = h[i] - h[i - 1];
            }
        }

        Arrays.sort(d, (o1, o2) -> o2 - o1);
        int sum = 0;
        for (int i = K; i < N; i++) {
            sum += d[i];
        }

        System.out.println(sum);
    }
}