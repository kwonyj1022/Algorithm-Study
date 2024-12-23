import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int L;
    static int[][] map;
    static int[] dir;
    static int[] dr;
    static int[] dc;
    static Deque<int[]> snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];
        dir = new int[10001];
        dr = new int[]{-1, 0, 1, 0}; // 상 우 하 좌
        dc = new int[]{0, 1, 0, -1};
        for (int i = 0; i < N + 2; i++) { // 벽 = -1
            map[0][i] = -1;
            map[i][0] = -1;
            map[N + 1][i] = -1;
            map[i][N + 1] = -1;
        }
        for (int i = 0; i < K; i++) { // 사과 = 1
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }
        L = Integer.parseInt(br.readLine());
        int t = 0;
        int d = 1;
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            for (int j = t; j < X; j++) {
                dir[j] = d;
            }
            d = nextDir(d, C);
            dir[X] = d;
            t = X + 1;
        }
        for (int i = t; i < 10001; i++) {
            dir[i] = d;
        }

        int hr = 1;
        int hc = 1;
        snake = new ArrayDeque<>();
        snake.addFirst(new int[]{hr, hc});
        map[hr][hc] = 2; // 뱀 = 2
        int time = 0;
        while (true) {
            hr += dr[dir[time]];
            hc += dc[dir[time]];
            time++;
            if (map[hr][hc] == -1 || map[hr][hc] == 2) {
                break;
            }
            if (map[hr][hc] == 0) { // 빈칸 = 0
                int[] tail = snake.pollLast();
                map[tail[0]][tail[1]] = 0;
            }
            map[hr][hc] = 2;
            snake.addFirst(new int[]{hr, hc});
        }
        System.out.print(time);
    }

    static int nextDir(int curDir, char C) {
        if (C == 'L') {
            return (curDir + 3) % 4;
        } else {
            return (curDir + 1) % 4;
        }
    }
}
