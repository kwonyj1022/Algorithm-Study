import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static int[][]  board;
    static boolean[] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        board = new int[R][C];
        visited = new boolean[26];
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = row.charAt(j) - 'A';
            }
        }
        visited[board[0][0]] = true;
        solve(0, 0, 1);
        System.out.print(answer);
	}
    
    static void solve(int r, int c, int cnt) {
        answer = Math.max(answer, cnt);
        for (int i = 0; i < 4; i++) {
            
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }
            if (!visited[board[nr][nc]]) {
                visited[board[nr][nc]] = true;
                solve(nr, nc, cnt + 1);
                visited[board[nr][nc]] = false;
            }
        }
    }
}
