import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        sum -= 100;
        Arrays.sort(arr);
        int l = 0;
        int r = 8;
        while(l <= r) {
            int t = arr[l] + arr[r];
            if (t == sum) {
                arr[l] = 0;
                arr[r] = 0;
                break;
            }

            if (t < sum) {
                l++;
            } else {
                r--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (arr[i] == 0) {
                continue;
            }
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}
