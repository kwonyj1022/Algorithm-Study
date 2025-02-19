import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }
        int len = input[0].length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            boolean isSame = true;
            char c = input[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (c != input[j].charAt(i)) {
                    isSame = false;
                }
            }
            if (isSame) {
                sb.append(c);
            } else {
                sb.append("?");
            }
        }
        
        System.out.print(sb);
    }
}
