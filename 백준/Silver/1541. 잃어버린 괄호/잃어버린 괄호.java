import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int answer = 0;
        int idx = 0;
        boolean flag = true; // +
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '+') {
                int n = Integer.parseInt(str.substring(idx, i));
                answer += flag ? n : -n;
                idx = i + 1;
            } else if (str.charAt(i) == '-') {
                int n = Integer.parseInt(str.substring(idx, i));
                answer += flag ? n : -n;
                if (flag) {
                    flag = !flag;
                }
                idx = i + 1;
            }
        }
        int n = Integer.parseInt(str.substring(idx));
        answer += flag ? n : -n;

        System.out.println(answer);
    }
}