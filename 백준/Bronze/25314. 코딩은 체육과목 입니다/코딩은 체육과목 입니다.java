import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = N / 4;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cnt; i++) {
            sb.append("long ");
        }
        sb.append("int");

        System.out.println(sb);
    }
}