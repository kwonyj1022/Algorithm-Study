import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, D;
    static List<int[]>[] info;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        info = new ArrayList[D + 1];
        distance = new int[D + 1];

        for (int i = 0; i <= D; i++) {
            info[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (e > D || e - s <= d) {
                continue;
            }

            info[s].add(new int[]{e, d});
        }

        dijkstra();

        System.out.print(distance[D]);
    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0});
        distance[0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int p = current[0];
            int d = current[1];

            if (distance[p] < d) {
                continue;
            }

            if (p < D && distance[p + 1] > d + 1) {
                distance[p + 1] = d + 1;
                pq.add(new int[]{p + 1, d + 1});
            }

            for (int[] road : info[p]) {

                if (distance[road[0]] > d + road[1]) {
                    distance[road[0]] = d + road[1];
                    pq.add(new int[]{road[0], distance[road[0]]});
                }
            }
        }
    }
}
