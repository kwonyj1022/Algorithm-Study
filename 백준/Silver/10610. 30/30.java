import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[10];
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            arr[n]++;
            total += n;
        }

        if (!str.contains("0") || total % 3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}
