import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.print("0\n0");
            return;
        }
        int nn = Math.abs(n);
        StringBuilder sb = new StringBuilder();
        int[] f = new int[nn + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= nn; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 1000000000;
        }
        int answer;
        if (n < 0 && n % 2 == 0) {
            answer = -f[nn];
        } else {
            answer = f[nn];
        }
        if (answer < 0) {
            sb.append("-1\n");
        } else if (answer == 0) {
            sb.append("0\n");
        } else {
            sb.append("1\n");
        }
        sb.append(f[nn]);
        System.out.print(sb);
	}
}
