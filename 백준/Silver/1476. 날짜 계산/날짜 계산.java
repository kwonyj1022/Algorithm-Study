import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        int answer = 1;
        while (true) {
            if (answer % 15 == E || (answer % 15 == 0 && E == 15)) {
                if (answer % 28 == S || (answer % 28 == 0 && S == 28)) {
                    if (answer % 19 == M || (answer % 19 == 0 && M == 19)) {
                        break;
                    }
                }
            }
            answer++;
        }
        System.out.print(answer);
    }
}
