import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static int X;
    static List<Integer>[] map;
    static boolean[] visited;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A].add(B);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{X, 0});
        visited[X] = true;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int d = poll[1];
            if (d > K) {
                break;
            }
            if (d == K) {
                answer.add(poll[0]);
            }
            d++;
            for (int n : map[poll[0]]) {
                if (visited[n]) {
                    continue;
                }
                q.offer(new int[]{n, d});
                visited[n] = true;
            }
        }
        if (answer.isEmpty()) {
            System.out.print(-1);
            return;
        }
        answer.sort(Comparator.comparingInt(o -> o));
        StringBuilder sb = new StringBuilder();
        for (int n : answer) {
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }
}
