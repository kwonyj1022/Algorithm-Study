import java.io.*;
import java.util.*;

public class Main {

    static int[] dl = {0, 0, 0, 0, 1, -1};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		while (true) {
            String input = br.readLine();
            if ("0 0 0".equals(input)) {
                break;
            }
            String[] split = input.split(" ");
            int L = Integer.parseInt(split[0]);
            int R = Integer.parseInt(split[1]);
            int C = Integer.parseInt(split[2]);
            Node start = new Node(0, 0, 0, 0);
            char[][][] b = new char[L][R][C];
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    b[l][r] = br.readLine().toCharArray();
                    for (int c = 0; c < C; c++) {
                        if (b[l][r][c] == 'S') {
                            start = new Node(l, r, c, 0);
                        }
                    }
                }
                br.readLine();
            }
            Queue<Node> q = new ArrayDeque<>();
            q.offer(start);
            boolean escaped = false;
            while (!q.isEmpty()) {
                Node poll = q.poll();
                if (b[poll.l][poll.r][poll.c] == 'E') {
                    sb.append("Escaped in ").append(poll.x).append(" minute(s).\n");
                    escaped = true;
                    break;
                }
                if (b[poll.l][poll.r][poll.c] == '#') {
                    continue;
                }
                b[poll.l][poll.r][poll.c] = '#';
                int nx = poll.x + 1;
                for (int i = 0; i < 6; i++) {
                    int nl = poll.l + dl[i];
                    int nr = poll.r + dr[i];
                    int nc = poll.c + dc[i];
                    if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C && b[nl][nr][nc] != '#') {
                        q.offer(new Node(nl, nr, nc, nx));
                    }
                }
            }
            if (!escaped) {
                sb.append("Trapped!\n");
            }
        }
        System.out.print(sb);
	}

    static class Node {
        int l;
        int r;
        int c;
        int x;

        Node(int l, int r, int c, int x) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.x = x;
        }
    }
}
