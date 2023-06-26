import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (isGroupWord(str)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isGroupWord(String str) {
        int length = str.length();
        boolean[] check = new boolean[26];
        check[str.charAt(0) - 'a'] = true;
        for (int i = 1; i < length; i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                if (check[str.charAt(i) - 'a']) {
                    return false;
                }
                check[str.charAt(i) - 'a'] = true;
            }
        }
        return true;
    }
}