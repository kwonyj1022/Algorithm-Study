import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        square = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                square[i][j] = s.charAt(j) - '0';
            }
        }

        int ml = Math.min(N, M);
        int answer = 0;
        for (int i = ml; i > 0; i--) {
            if (exist(i - 1)) {
                answer = i * i;
                break;
            }
        }

        System.out.println(answer);
    }

    private static boolean exist(int d) {
        for (int i = 0; i < N - d; i++) {
            for (int j = 0; j < M - d; j++) {
                if (square[i][j] == square[i + d][j] && square[i][j] == square[i][j + d] && square[i][j] == square[i + d][j + d]) {
                    return true;
                }
            }
        }
        return false;
    }
}