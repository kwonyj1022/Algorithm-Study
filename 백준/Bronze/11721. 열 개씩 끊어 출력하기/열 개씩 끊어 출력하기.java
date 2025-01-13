import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int i = 10;
        for (; i < input.length(); i += 10) {
            sb.append(input.substring(i - 10, i)).append("\n");
        }
        sb.append(input.substring(i - 10));
        System.out.println(sb);
    }
}
