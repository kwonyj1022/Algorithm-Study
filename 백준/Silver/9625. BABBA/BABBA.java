import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 0;
        for (int i = 0; i < K; i++) {
            int preA = a;
            a = b;
            b = preA + b;
        }
        System.out.println(a + " " + b);
    }
}
