import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int min = 2000;
        int max5 = N / 5;
        for (int i = 0; i <= max5; i++) {
            int r = N - i * 5;
            if (r % 3 == 0) {
                min = Math.min(min, i + r / 3);
            }
        }

        if (min == 2000) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}