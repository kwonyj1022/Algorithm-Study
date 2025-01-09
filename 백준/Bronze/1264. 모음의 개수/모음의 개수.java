import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] moeum = {'a', 'e', 'i', 'o', 'u'};
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if ("#".equals(str)) {
                break;
            }
            int answer = 0;
            str = str.toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < 5; j++) {
                    if (str.charAt(i) == moeum[j]) {
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
