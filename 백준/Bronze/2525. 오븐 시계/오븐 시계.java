import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        int tmp = m + t;
        h = (h + tmp / 60) % 24;
        m = tmp % 60;

        StringBuffer sb = new StringBuffer();
        sb.append(h).append(" ").append(m);
        System.out.println(sb);
    }
}