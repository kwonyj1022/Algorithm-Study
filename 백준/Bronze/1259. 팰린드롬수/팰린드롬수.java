import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }
            f(num);
        }
    }

    public static void f(String num) {
        int len = num.length();
        int t = len / 2;
        for (int i = 0; i < t; i++) {
            if (num.charAt(i) != num.charAt(len - 1 - i)) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}