import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmpN = br.readLine();
        int N = Integer.parseInt(tmpN);
        int len = tmpN.length();

        int s = N - len * 9;
        int e = N - len;
        for (int i = s; i <= e; i++) {
            if (f(i) == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    public static int f(int num) {
        int a = num;
        while (num > 0) {
            a += num % 10;
            num /= 10;
        }
        return a;
    }
}