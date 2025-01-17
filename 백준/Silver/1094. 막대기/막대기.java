import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        char[] binary = Integer.toBinaryString(X).toCharArray();
        int answer = 0;
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == '1') {
                answer++;
            }
        }
        System.out.print(answer);
    }
}
