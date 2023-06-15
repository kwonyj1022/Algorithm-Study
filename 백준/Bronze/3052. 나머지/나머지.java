import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] r = new boolean[42];
        for (int i = 0; i < 42; i++) {
            r[i] = false;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            r[n % 42] = true;
        }

        int answer = 0;
        for (int i = 0; i < 42; i++) {
            if (r[i] == true) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}