import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static int k;
    static int[] arr;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = new int[6];
            visited = new boolean[k];

            solve(0, 0);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void solve(int idx, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i < k; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result[depth] = arr[i];
            solve(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}
