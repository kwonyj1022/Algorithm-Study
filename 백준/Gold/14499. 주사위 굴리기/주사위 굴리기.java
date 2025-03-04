import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M, x, y;
    static int[][] map;
    static int[] dice;
    static int topIdx, frontIdx, rightIdx;
    static int[] dx, dy;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);
        y = Integer.parseInt(input[3]);
        int K = Integer.parseInt(input[4]);
        map = new int[N][M];
        dice = new int[6];
        topIdx = 0;
        frontIdx = 1;
        rightIdx = 2;
        dx = new int[]{0, 0, 0, -1, 1};
        dy = new int[]{0, 1, -1, 0, 0};
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j].charAt(0) - '0';
            }
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            move(input[i].charAt(0) - '0');
        }
        System.out.print(sb);
    }

    static void move(int cmd) {
        int nx = x + dx[cmd];
        int ny = y + dy[cmd];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
            return;
        }
        x = nx;
        y = ny;

        if (cmd == 1) {
            int tmp = topIdx;
            topIdx = 5 - rightIdx;
            rightIdx = tmp;
        } else if (cmd == 2) {
            int tmp = topIdx;
            topIdx = rightIdx;
            rightIdx = 5 - tmp;
        } else if (cmd == 3) {
            int tmp = topIdx;
            topIdx = 5 - frontIdx;
            frontIdx = tmp;
        } else {
            int tmp = topIdx;
            topIdx = frontIdx;
            frontIdx = 5 - tmp;
        }

        if (map[x][y] == 0) {
            map[x][y] = dice[5 - topIdx];
        } else {
            dice[5 - topIdx] = map[x][y];
            map[x][y] = 0;
        }
        sb.append(dice[topIdx]).append('\n');
    }
}
