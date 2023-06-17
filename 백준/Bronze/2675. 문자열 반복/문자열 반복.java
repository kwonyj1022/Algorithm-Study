import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringBuffer sb = new StringBuffer();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            int size = S.length();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(S.charAt(j));
                }
            }
            System.out.println(sb);
        }
    }
}