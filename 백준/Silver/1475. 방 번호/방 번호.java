import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] N = br.readLine().toCharArray();
        int[] arr = new int[9];
        for (char c : N) {
            if (c == '9') {
                arr[6]++;
            } else {
                arr[c - '0']++;
            }
        }
        arr[6] = arr[6] / 2 + arr[6] % 2;

        int answer = 0;
        for (int i = 0; i < 9; i++) {
            answer = Math.max(answer, arr[i]);
        }
        System.out.print(answer);
    }
}
