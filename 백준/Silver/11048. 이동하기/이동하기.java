import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = max(i, j) + n;
            }
        }
        System.out.print(arr[N][M]);
	}

    static int max(int r, int c) {
        return Math.max(Math.max(arr[r - 1][c], arr[r][c - 1]), arr[r - 1][c - 1]);
    }
}
