import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Set<String> subStrings = new HashSet<>();

        int len = S.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                subStrings.add(S.substring(i, j));
            }
        }
        System.out.print(subStrings.size());
    }
}
