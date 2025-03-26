import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            BigInteger n = new BigInteger(br.readLine());
            if (n.isProbablePrime(10)) {
                sb.append(n).append("\n");
            } else {
                sb.append(n.nextProbablePrime()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
