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
        int[] basket = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }
        for (int x = 0; x < M; x++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int t = (j - i) / 2 + 1;
            for (int y = 0; y < t; y++) {
                int tmp = basket[i + y];
                basket[i + y] = basket[j - y];
                basket[j - y] = tmp;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            sb.append(basket[i]).append(" ");
        }
        System.out.println(sb);
    }
}