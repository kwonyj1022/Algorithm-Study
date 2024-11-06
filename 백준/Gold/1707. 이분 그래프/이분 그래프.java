import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            color = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
                color[i] = 0;
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            boolean isBipartite = true;
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= V; i++) {
                if (color[i] != 0) {
                    continue;
                }
                color[i] = 1;
                q.offer(i);
                while (!q.isEmpty()) {
                    int t = q.poll();
                    for (int j = 0; j < graph[t].size(); j++) {
                        if (color[graph[t].get(j)] == color[t]) {
                            isBipartite = false;
                            break;
                        }
                        if (color[graph[t].get(j)] == 0) {
                            color[graph[t].get(j)] = -color[t];
                            q.offer(graph[t].get(j));
                        }
                    }
                    if (!isBipartite) {
                        break;
                    }
                }
                if (!isBipartite) {
                    break;
                }
            }
            if (isBipartite) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
