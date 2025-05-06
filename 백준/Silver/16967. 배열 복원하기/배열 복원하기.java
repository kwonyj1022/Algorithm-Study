import java.io.*;
import java.util.*;

public class Main {

    static int H, W, X, Y;
    static int[][] A, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        A = new int[H][W];
        int bh = H + X;
        int bw = W + Y;
        B = new int[bh][bw];
        for (int i = 0; i < bh; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < bw; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (i - X < 0 || j - Y < 0) {
                    A[i][j] = B[i][j];
                } else {
                    A[i][j] = B[i][j] - A[i - X][j - Y];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(A[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
	}
}
