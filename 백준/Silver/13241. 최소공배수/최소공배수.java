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
        long lcm = A * B;
        if (A < B) {
            long tmp = B;
            B = A;
            A = tmp;
        }
        while (B > 0) {
            long tmp = A % B;
            A = B;
            B = tmp;
        }
        System.out.println(lcm / A);
    }
}