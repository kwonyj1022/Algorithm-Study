import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int answer = 1;
        int size = word.length();
        for (int i = 0; i < size / 2; i++) {
            if (word.charAt(i) != word.charAt(size - i - 1)) {
                answer = 0;
                break;
            }
        }
        System.out.println(answer);
    }
}