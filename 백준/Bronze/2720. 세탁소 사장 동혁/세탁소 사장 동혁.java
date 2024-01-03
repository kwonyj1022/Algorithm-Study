import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int C = Integer.parseInt(br.readLine());
            int q = C / 25;
            C -= q * 25;
            int d = C / 10;
            C -= d * 10;
            int n = C / 5;
            C -= n * 5;
            sb.append(q).append(" ").append(d).append(" ").append(n).append(" ").append(C).append("\n");
        }

        System.out.println(sb);
    }
}