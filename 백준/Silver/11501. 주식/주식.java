import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static StringBuilder sb;
    static int N;
    static int[] price;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            price = new int[N];
            pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
                pq.offer(new int[] {price[i], i});
            }
            solve();
        }
        System.out.println(sb);
    }

    static void solve() {
        int day = 0;
        long answer = 0;
        while(!pq.isEmpty()) {
            int[] max = pq.poll();
            if (max[1] < day) {
                continue;
            }
            long cnt = 0;
            while (day < max[1]) {
                answer -= price[day];
                cnt++;
                day++;
            }
            answer += cnt * max[0];
            day++;
        }
        sb.append(answer).append('\n');
    }
}
