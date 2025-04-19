import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String answer = "z";
        for (int i = 1; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                String tmp = reverse(word.substring(0, i)) + reverse(word.substring(i, j)) + reverse(word.substring(j));
                if (answer.compareTo(tmp) > 0) {
                    answer = tmp;
                }
            }
        }
        System.out.print(answer);
    }

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
