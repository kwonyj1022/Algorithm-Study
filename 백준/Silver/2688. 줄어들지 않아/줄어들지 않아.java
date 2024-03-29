import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] input = new int[T];
        for (int i = 0; i < T; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        long[][] arr = new long[64][10];
        for (int i = 0; i < 64; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < 10; i++) {
            arr[0][i] = i + 1;
        }

        for (int i = 1; i < 64; i++) {
            for (int j = 1; j < 10; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(arr[input[i] - 1][9]);
        }
    }
}