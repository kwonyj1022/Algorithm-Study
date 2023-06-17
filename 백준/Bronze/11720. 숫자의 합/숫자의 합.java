import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int sum = 0;
        int size = input.length();
        for (int i = 0; i < size; i++) {
            sum += Integer.parseInt(input.substring(i, i + 1));
        }
        System.out.println(sum);
    }
}