import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        int tmp = N;
        int n = 0;
        while (tmp > 0) {
            n++;
            tmp /= 10;
        }

        int s = N - 9 * n;
        int e = N - n;
        for (int i = s; i <= e; i++) {
            if (f(i) == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    public static int f(int num) {
        int a = num;
        while (num > 0) {
            a += num % 10;
            num /= 10;
        }
        return a;
    }
}