import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nstr = new Scanner(System.in).next();
        int[] arr = new int[nstr.length()];
        for (int i = 0; i < nstr.length(); i++) {
            arr[i] = nstr.charAt(i) - '0';
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = nstr.length() - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        System.out.print(sb);
    }
}
