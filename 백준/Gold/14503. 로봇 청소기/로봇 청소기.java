import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M, r, c, d;
    static int[] dr, dc;
    static char[][] room;
    static int answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        String[] rcd = br.readLine().split(" ");
        r = Integer.parseInt(rcd[0]);
        c = Integer.parseInt(rcd[1]);
        d = Integer.parseInt(rcd[2]);
        room = new char[N][M];
        for (int i = 0; i < N; i++) {
            room[i] = br.readLine().replace(" ", "").toCharArray();
        }
        dr = new int[]{-1, 0, 1, 0};
        dc = new int[]{0, 1, 0, -1};
        answer = 0;

        while (true) {
            if (room[r][c] == '0') {
                room[r][c] = '2';
                answer++;
            }
            boolean hasBlank = false;
            for (int i = 0; i < 4; i++) {
                rotate();
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || room[nr][nc] != '0') {
                    continue;
                }
                hasBlank = true;
                r = nr;
                c = nc;
                break;
            }
            if (!hasBlank) {
                int nr = r - dr[d];
                int nc = c - dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || room[nr][nc] == '1') {
                    break;
                }
                r = nr;
                c = nc;
            }
        }
        System.out.print(answer);
    }

    static void rotate() {
        d = (d + 3) % 4;
    }
}
