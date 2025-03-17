import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {

    static StringBuilder sb;
    static Set<Character> moeum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        moeum = Set.of('a', 'e', 'i', 'o', 'u');
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            solve(input.toCharArray());
        }
        System.out.print(sb);
    }

    static void solve(char[] word) {
        boolean con1 = false;
        boolean con2 = true;
        boolean con3 = true;
        int moeumCnt = 0;
        int jaeumCnt = 0;
        char pre = 0;
        for (char c: word) {
            if (moeum.contains(c)) {
                con1 = true;
                moeumCnt++;
                jaeumCnt = 0;
            } else {
                jaeumCnt++;
                moeumCnt = 0;
            }
            if (moeumCnt == 3 || jaeumCnt == 3) {
                con2 = false;
                break;
            }
            if (pre == c && c != 'e' && c != 'o') {
                con3 = false;
                break;
            }
            pre = c;
        }
        if (con1 && con2 && con3) {
            sb.append("<").append(word).append("> is acceptable.\n");
        } else {
            sb.append("<").append(word).append("> is not acceptable.\n");
        }
    }
}
