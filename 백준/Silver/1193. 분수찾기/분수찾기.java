import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int tmp = 0;
        int i = 1;
        while (true) {
            tmp += i;
            if (tmp >= X) {
                int y = tmp - X;
                if (i % 2 == 0) {
                    sb.append(i - y).append("/").append(y + 1);
                    System.out.println(sb);
                    return;

                }
                sb.append(y + 1).append("/").append(i - y);
                System.out.println(sb);
                return;
            }
            i++;
        }
    }
}