import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            arr[name.charAt(0) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 5) {
                sb.append((char) (i + 'a'));
            }
        }

        if (sb.length() == 0) {
            System.out.print("PREDAJA");
        } else {
            System.out.print(sb);
        }
    }
}
