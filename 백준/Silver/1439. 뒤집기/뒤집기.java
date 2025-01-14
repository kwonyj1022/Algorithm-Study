import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int zero = 0;
        int one = 0;
        char before = '.';
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == before) {
                continue;
            }
            if (S.charAt(i) == '0') {
                zero++;
                before = '0';
            } else {
                one++;
                before = '1';
            }
        }

        System.out.print(Math.min(zero, one));
    }
}
