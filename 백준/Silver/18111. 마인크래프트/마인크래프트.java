import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int height = 0;
        int[][] ground = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int t = Integer.parseInt(st.nextToken());
                ground[i][j] = t;
                if (t > height) {
                    height = t;
                }
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = 0;
        while (height >= 0) {
            int timeSum = 0;
            int blockRemain = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int d = ground[i][j] - height;
                    if (d > 0) {
                        timeSum += Math.abs(d * 2);
                    } else {
                        timeSum += Math.abs(d);
                    }
                    blockRemain += d;
                }
            }
            if (timeSum < answerTime) {
                if (timeSum >= 0 && blockRemain + B >= 0) {
                    answerTime = timeSum;
                    answerHeight = height;
                }
            } else {
                break;
            }

            height--;
        }

        System.out.printf("%d %d", answerTime, answerHeight);
    }
}