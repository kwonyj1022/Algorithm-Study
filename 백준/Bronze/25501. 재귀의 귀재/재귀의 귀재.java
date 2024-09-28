import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int rcnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            rcnt = 0;
            String S = br.readLine();
            int t = isPalindrome(S);
            sb.append(t).append(' ').append(rcnt).append('\n');
        }
        System.out.print(sb);
    }

    static int recursion(String str, int l, int r) {
        rcnt++;
        if (l >= r) {
            return 1;
        }
        if (str.charAt(l) != str.charAt(r)) {
            return 0;
        }
        return recursion(str, l + 1, r - 1);
    }

    static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }
}
