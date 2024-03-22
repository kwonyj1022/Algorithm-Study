import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i < 11; i++) {
            int n = 0;
            for (int j = 1; j < i; j++) {
                if (j > 3) {
                    break;
                }
                n += arr[i - j];
            }
            arr[i] = n;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append("\n");
        }

        System.out.println(sb);
    }
}