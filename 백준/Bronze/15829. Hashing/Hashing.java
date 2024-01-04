import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        BigInteger answer = BigInteger.ZERO;
        for (int i = 0; i < L; i++) {
            answer = answer.add(BigInteger.valueOf(str.charAt(i) - 'a' + 1).multiply(BigInteger.valueOf(31).pow(i)));
            answer = answer.mod(BigInteger.valueOf(1234567891));
        }

        System.out.println(answer);
    }
}