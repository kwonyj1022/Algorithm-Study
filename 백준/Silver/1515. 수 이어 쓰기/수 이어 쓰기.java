import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int idx = 0;
        int N = 1;
        while (N <= 30000) {
            String nstring = String.valueOf(N);
            for (int i = 0; i < nstring.length(); i++) {
                if (nstring.charAt(i) == input.charAt(idx)) {
                    idx++;
                }
                if (idx == input.length()) {
                    System.out.print(N);
                    return;
                }
            }
            N++;
        }
    }
}
