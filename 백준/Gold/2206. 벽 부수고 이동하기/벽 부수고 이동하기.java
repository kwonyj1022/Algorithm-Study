import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int N, M;
    static char[][] map;
    static int[][][] visited;
    static Queue<int[]> q;
    static int[] dn, dm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N + 1][M + 1];
        visited = new int[N + 1][M + 1][2];
        for (int i = 1; i <= N; i++) {
            System.arraycopy(br.readLine().toCharArray(), 0, map[i], 1, M);
        }

        dn = new int[]{-1, 1, 0, 0};
        dm = new int[]{0, 0, -1, 1};

        q = new ArrayDeque<>();
        q.offer(new int[]{1, 1, 0});
        visited[1][1][0] = 1;
        int answer = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int x = poll[0], y = poll[1], broken = poll[2];
                if (x == N && y == M) {
                    System.out.print(answer);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int nn = x + dn[j];
                    int nm = y + dm[j];
                    if (nn <= 0 || nn > N || nm <= 0 || nm > M) {
                        continue;
                    }

                    if (map[nn][nm] == '0' && visited[nn][nm][broken] == 0) {
                        visited[nn][nm][broken] = 1;
                        q.offer(new int[]{nn, nm, broken});
                    }
                    if (map[nn][nm] == '1' && broken == 0 && visited[nn][nm][1] == 0) {
                        visited[nn][nm][1] = 1;
                        q.offer(new int[]{nn, nm, 1});
                    }
                }
            }
            answer++;
        }
        System.out.print(-1);
    }
}
