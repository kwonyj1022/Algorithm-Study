import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int min = Math.min(A, B);
            int gcm;
            int n = 1;
            while(n <= min) {
                gcm  = min / n++;
                if (A % gcm == 0 && B % gcm == 0) {
                    System.out.println(A * B / gcm);
                    break;
                }
            }
        }
    }
}