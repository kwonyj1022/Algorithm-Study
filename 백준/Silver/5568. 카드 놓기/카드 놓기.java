import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {
    static int n, k;
    static int[] card;
    static boolean[] visited;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        card = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }
        visited = new boolean[n];
        set = new HashSet<>();
        solve(0, "");
        System.out.print(set.size());
    }

    public static void solve(int depth, String str) {
        if (depth == k) {
            set.add(str);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve(depth + 1, str + card[i]);
                visited[i] = false;
            }
        }

    }
}
