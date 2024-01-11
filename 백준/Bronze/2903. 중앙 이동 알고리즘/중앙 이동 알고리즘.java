import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[16];
        arr[0] = 2;
        for (int i = 1; i < 16; i++) {
            arr[i] = 2 * arr[i - 1] - 1;
        }

        int N = sc.nextInt();
        System.out.println(arr[N] * arr[N]);
    }
}