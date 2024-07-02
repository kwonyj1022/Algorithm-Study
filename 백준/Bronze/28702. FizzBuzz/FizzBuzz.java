import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = -3;
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            if (str.charAt(0) != 'F' && str.charAt(0) != 'B') {
                n = Integer.parseInt(str);
            } else {
                n++;
            }
        }
        n++;
        boolean m3 = n % 3 == 0;
        boolean m5 = n % 5 == 0;
        if (m3 && m5) {
            System.out.println("FizzBuzz");
        } else if (m3) {
            System.out.println("Fizz");
        } else if (m5) {
            System.out.println("Buzz");
        } else {
            System.out.println(n);
        }
        br.close();
    }
}