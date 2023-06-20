import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int time = 0;
        for (int i = 0; i < input.length(); i++) {
            int num = 9;
            if (input.charAt(i) <= 'R') {
                num = (input.charAt(i) - 'A' + 6) / 3;
            } else if (input.charAt(i) < 'Z'){
                num = (input.charAt(i) - 'A' + 5) / 3;
            }
            time += num + 1;
        }
        System.out.println(time);
    }
}