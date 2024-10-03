import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }
            long N = Long.parseLong(input);
            solve((long) Math.pow(3, N), true);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void solve(long n, boolean active) {
        if (n == 1) {
            sb.append(active ? '-' : ' ');
            return;
        }
        long d = n / 3;
        if (active) {
            solve(d, true);
            solve(d, false);
            solve(d, true);
        } else {
            solve(d, false);
            solve(d, false);
            solve(d, false);
        }
    }
}
