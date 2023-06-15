import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] s = new int[31];
        for (int i = 1; i <= 30; i++) {
            s[i] = 0;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 28; i++) {
            int y = Integer.parseInt(br.readLine());
            s[y] = 1;
        }

        for (int i = 1; i <= 30; i++) {
            if (s[i] == 0) {
                System.out.println(i);
            }
        }
    }
}