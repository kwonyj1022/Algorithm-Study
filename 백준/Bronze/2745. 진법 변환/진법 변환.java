import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String Nstr = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        int t = 1;
        int answer = 0;
        for (int i = Nstr.length() - 1; i >= 0; i--) {
            char c = Nstr.charAt(i);
            if ('0' <= c && c <= '9') {
                answer += t * (c - '0');
            } else {
                answer += t * (c - 'A' + 10);
            }
            t *= N;
        }
        System.out.println(answer);
    }
}