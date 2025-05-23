import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[] rowSum;
    static int[] colSum;
    static boolean[] visited;
    static int all;
    static int answer;
    static int score1;
    static int half;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        half = N / 2;
        arr = new int[N][N];
        rowSum = new int[N];
        colSum = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                all += arr[i][j];
                rowSum[i] += arr[i][j];
                colSum[j] += arr[i][j];
            }
        }

        answer = Integer.MAX_VALUE;
        solve(0, 0);
        System.out.print(answer);
    }

    static void solve(int cur, int depth) {
        if (depth == half) {
            int cha = all;
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    cha -= rowSum[i];
                    cha -= colSum[i];
                }
            }
            answer = Math.min(answer, Math.abs(cha));

            return;
        }

        for (int i = cur; i < N; i++) {
            int plus = 0;
            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    plus += arr[i][j];
                    plus += arr[j][i];
                }
            }
            score1 += plus;
            visited[i] = true;
            solve(i + 1, depth + 1);
            score1 -= plus;
            visited[i] = false;
        }
    }
}
