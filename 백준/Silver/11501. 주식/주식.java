import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static StringBuilder sb;
    static int N;
    static int[] price, profit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            price = new int[N];
            profit = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for (int i = N - 1; i >= 0; i--) {
                max = Math.max(max, price[i]);
                profit[i] = max;
            }
            long answer = 0;
            for (int i = 0; i < N; i++) {
                answer += profit[i] - price[i];
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
