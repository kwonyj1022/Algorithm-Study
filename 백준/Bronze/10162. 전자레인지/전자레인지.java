import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int a = T / 300;
        T %= 300;
        int b = T / 60;
        T %= 60;
        int c = T / 10;
        if (T % 10 != 0) {
            System.out.print(-1);
        } else {
            System.out.print(a + " " + b + " " + c);
        }
    }
}
