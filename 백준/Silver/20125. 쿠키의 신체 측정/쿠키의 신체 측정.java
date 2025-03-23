import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] heart = new int[2];
        int[] answer = new int[5];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == '_') {
                    continue;
                }
                if (heart[0] == 0) {
                    heart[0] = i + 1;
                    heart[1] = j;

                    continue;
                }
                if (i == heart[0]) {
                    if (j < heart[1] && answer[0] == 0) {
                        answer[0] = heart[1] - j;
                    } else if (j > heart[1]) {
                        answer[1]++;
                    }
                    continue;
                }
                if (j == heart[1]) {
                    answer[2]++;
                    continue;
                }
                if (j < heart[1]) {
                    answer[3]++;
                } else {
                    answer[4]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");
        for (int i = 0; i < 5; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb);
    }
}
