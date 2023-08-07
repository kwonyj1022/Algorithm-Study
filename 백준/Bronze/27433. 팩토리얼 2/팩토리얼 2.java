import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        System.out.println(f(N));
    }

    private static long f(int n) {
        if (n == 0) {
            return 1;
        }
        return n * f(n - 1);
    }
}