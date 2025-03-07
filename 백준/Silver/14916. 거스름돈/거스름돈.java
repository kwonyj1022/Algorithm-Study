import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = n / 5;
        int r = n % 5;
        for (int i = cnt; i >= 0; i--) {
            if (r % 2 == 0) {
                System.out.print(i + r / 2);
                return;
            }
            r += 5;
        }
        System.out.print(-1);
    }
}
