import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Score[] scores = new Score[9];
        scores[0] = new Score(0, 0);
        for (int i = 1; i < 9; i++) {
            scores[i] = new Score(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(scores, (o1, o2) -> o2.score - o1.score);
        int sum = 0;
        boolean[] flag = new boolean[9];
        for (int i = 0; i < 5; i++) {
            sum += scores[i].score;
            flag[scores[i].num] = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");
        for (int i = 0; i < 9; i++) {
            if (flag[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.print(sb);
    }

    static class Score {
        int num;
        int score;

        Score(int num, int score) {
            this.num = num;
            this.score = score;
        }
    }
}
