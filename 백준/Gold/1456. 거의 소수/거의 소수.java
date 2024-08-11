import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        boolean[] notSosu = new boolean[10000001];
        for (int i = 2; i < 10000001; i++) {
            if (notSosu[i]) {
                continue;
            }
            for (int j = i + i; j < 10000001; j += i) {
                notSosu[j] = true;
            }
        }
        int cnt = 0;
        for (int i = 2; i < 10000001; i++) {
            if (notSosu[i]) {
                continue;
            }
            long tmp = i;
            while (i <= B / tmp) {
                if (i >= A / tmp) {
                    cnt++;
                }
                tmp *= i;
            }
        }
        System.out.print(cnt);
    }
}