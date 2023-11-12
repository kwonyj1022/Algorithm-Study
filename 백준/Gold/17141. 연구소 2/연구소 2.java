import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class position {
        int x, y;
        
        public position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static int[][] input;
    static ArrayList<position> virus = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static position[] virusPosition;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                if (input[i][j] == 2)
                    virus.add(new position(j, i));
            }
        }
        virusPosition = new position[M];

        search(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void search(int count, int start) {
        if (count == M) {
            bfs();
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            virusPosition[count] = virus.get(i);
            search(count + 1, i + 1);
        }
    }

    static void bfs() {
        Queue<position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int result = 0;
        for (int i = 0; i < M; i++) {
            visited[virusPosition[i].y][virusPosition[i].x] = true;
            queue.add(virusPosition[i]);
        }
        while (!queue.isEmpty()) {
            if (result >= answer) {
                return;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                spread(queue, visited);
            }
            result++;
        }
        if (success(visited)) {
            answer = Math.min(answer, result - 1);
        }
    }

    private static void spread(final Queue<position> queue, final boolean[][] visited) {
        position cur = queue.poll();

        for (int j = 0; j < 4; j++) {
            int tempX = cur.x + dx[j];
            int tempY = cur.y + dy[j];
            if ((tempX >= 0 && tempY >= 0 && tempX < N && tempY < N) && !visited[tempY][tempX]) {
                if (input[tempY][tempX] != 1) {
                    visited[tempY][tempX] = true;
                    queue.add(new position(tempX, tempY));
                }
            }
        }
    }

    static boolean success(boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (input[i][j] != 1 && !visited[i][j])
                    return false;
            }
        }
        return true;
    }
}