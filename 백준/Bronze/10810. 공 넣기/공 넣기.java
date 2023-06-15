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

        int[] basket = new int[N];
        for (int t = 0; t < N; t++) {
            basket[t] = 0;
        }

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int s = i - 1; s < j; s++) {
                basket[s] = k;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append(basket[i]).append(" ");
        }
        System.out.println(sb);
    }
}