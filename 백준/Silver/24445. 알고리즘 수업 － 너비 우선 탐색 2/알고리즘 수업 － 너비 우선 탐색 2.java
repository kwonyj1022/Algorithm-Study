import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static List<List<Integer>> graph;
    static int[] visited;
    static StringBuilder sb;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>(N + 1);
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            graph.get(i).sort((o1, o2) -> o2 - o1);
        }

        sb = new StringBuilder();
        visited = new int[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(R);
        n = 1;

        while (!q.isEmpty()) {
            int poll = q.poll();
            if (visited[poll] != 0) {
                continue;
            }
            visited[poll] = n++;
            for (int next : graph.get(poll)) {
                if (visited[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }
}
