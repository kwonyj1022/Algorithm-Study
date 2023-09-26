import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String K = br.readLine();

        StringBuilder sb = new StringBuilder();
        int sLen = S.length();
        for (int i = 0; i < sLen; i++) {
            if (S.charAt(i) < '0' || S.charAt(i) > '9') {
                sb.append(S.charAt(i));
            }
        }
        
        if (sb.toString().contains(K)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}