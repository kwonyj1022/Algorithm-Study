import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 1;
        int add = 2;
        int cnt = 1;
        while (true) {
            if (sum > S) {
                break;
            }
            sum += add++;
            cnt++;
        }
        System.out.print(cnt - 1);
    }
}
