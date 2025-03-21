import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 0;
        int openCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                openCount++;
            } else if (input.charAt(i) == ')') {
                openCount--;
                if (input.charAt(i - 1) == '(') {
                    answer += openCount;
                } else {
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}
