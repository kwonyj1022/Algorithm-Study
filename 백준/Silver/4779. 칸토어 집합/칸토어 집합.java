import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder on = new StringBuilder("-");
        StringBuilder off = new StringBuilder(" ");
        String[] cache = new String[13];
        cache[0] = on.toString();
        for (int i = 1; i < 13; i++) {
            String prevSpace = off.toString();
            on.append(prevSpace).append(cache[i - 1]);
            off.append(prevSpace).append(prevSpace);
            cache[i] = on.toString();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }
            int N = Integer.parseInt(input);
            sb.append(cache[N]).append('\n');
        }

        System.out.print(sb);
    }
}