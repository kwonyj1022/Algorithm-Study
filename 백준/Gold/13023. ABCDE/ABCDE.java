import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if (dfs(i, 1)) {
                System.out.print(1);
                return;
            }
        }
        System.out.print(0);
    }

    static boolean dfs(int n, int depth) {
        visited[n] = true;
        if (depth == 5) {
            return true;
        }
        for (int i : graph[n]) {
            if (!visited[i]) {
                if (dfs(i, depth + 1)) {
                    return true;
                }
            }
        }
        visited[n] = false;
        return false;
    }
}