import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long min = Math.min(A, B);
        long gcm;
        long n = 1;
        while(n <= min) {
            gcm  = min / n++;
            if (A % gcm == 0 && B % gcm == 0) {
                System.out.println(A * B / gcm);
                break;
            }
        }
    }
}