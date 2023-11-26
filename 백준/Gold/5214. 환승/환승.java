import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N + M; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] v = new boolean[N + 1 + M];
        int[] distance = new int[N + 1 + M];

        for (int tubeNum = 1; tubeNum <= M; tubeNum++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int station = Integer.parseInt(st.nextToken());
                graph.get(station).add(N + tubeNum);
                graph.get(N + tubeNum).add(station);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        v[1] = true;
        distance[1] = 1;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to : graph.get(from)) {
                if (v[to]) {
                    continue;
                }
                v[to] = true;
                distance[to] = distance[from] + 1;
                queue.offer(to);
            }
        }

        if (v[N]) {
            System.out.println(distance[N] / 2 + 1);
        } else {
            System.out.println(-1);
        }
    }
}