import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 점화식: f(n) = 2*3^(n-2)
        int N = Integer.parseInt(br.readLine()) - 2;
        if (N == -1) {
            System.out.print(0);
            return;
        }
        BigInteger answer = new BigInteger("2");
        BigInteger three = new BigInteger("3");
        for (int i = 0; i < N; i++) {
            answer = answer.multiply(three);
        }
        answer = answer.mod(new BigInteger("1000000009"));
        System.out.print(answer);
	}
}
