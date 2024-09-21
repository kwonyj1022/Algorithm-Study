import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer>[] map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        boolean[] check = new boolean[n + 1];
        for (int f : map[1]) {
            check[f] = true;
            for (int ff : map[f]) {
                check[ff] = true;
            }
        }
        check[1] = false;

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
