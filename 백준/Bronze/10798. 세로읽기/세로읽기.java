import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = new String[5];
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            inputs[i] = new StringBuffer(str).append("              ").toString();
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                sb.append(inputs[j].charAt(i));
            }
        }
        System.out.println(sb.toString().replace(" ", ""));
    }
}