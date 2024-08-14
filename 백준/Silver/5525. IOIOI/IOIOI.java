import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        boolean isI = false;
        int idx = 0;
        int pn = 0;
        int cnt = 0;
        while (idx < M) {
            if (!isI && S.charAt(idx) == 'I') {
                isI = true;
                idx++;
            } else if (isI && S.charAt(idx) == 'O') {
                pn++;
                isI = false;
                idx++;
            } else {
                cnt += Math.max(0, S.charAt(idx) == 'I' ? pn - N + 1 : pn - N);
                pn = 0;
                isI = false;
                if (S.charAt(idx) == 'O') {
                    
                    idx++;
                }
            }
        }
        cnt += Math.max(0, S.charAt(idx - 1) == 'I' ? pn - N + 1 : pn - N);

        System.out.print(cnt);
    }
}