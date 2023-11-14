import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N = 0;
    static int M = 0;
    static int answer = 0;
    static int[][] map = new int[6][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] input = new int[6];
        st = new StringTokenizer(br.readLine());
        input[0] = Integer.parseInt(st.nextToken());
        input[1] = Integer.parseInt(st.nextToken());
        input[2] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input[3] = Integer.parseInt(st.nextToken());
        input[4] = Integer.parseInt(st.nextToken());
        input[5] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < 6; i++) {
            for (int j = i; j < 6; j++) {
                if (i == j) {
                    map[i][j] = input[j] / 2;
                } else if (i == j - 3) {
                    map[i][j] = input[j] / 2;
                    map[j][i] = input[i] / 2;
                } else {
                    map[i][j] = input[j];
                    map[j][i] = input[i];
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            solve(N, i, input[i]);
        }

        System.out.println(answer);
    }

    private static void solve(int n, int fromIdx, int from) {
        if (n == 1) {
            if (from >= M) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < 6; i++) {
            solve(n - 1, i, from + map[fromIdx][i]);
        }
    }
}