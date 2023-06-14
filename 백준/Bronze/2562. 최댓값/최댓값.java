import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[9];
        for (int i = 0; i < 9; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int maxNum = numbers[0];
        int maxIdx = 1;
        for (int i = 1; i < 9; i++) {
            if (numbers[i] > maxNum) {
                maxNum = numbers[i];
                maxIdx = i + 1;
            }
        }
        System.out.println(maxNum);
        System.out.println(maxIdx);
    }
}