import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        int two = 0;
        int five = 0;
        for (int i = 2; i <= N; i++) {
            int tmp = i;
            while (tmp % 2 == 0) {
                tmp /= 2;
                two++;
            }
            while (tmp % 5 == 0) {
                tmp /= 5;
                five++;
            }
        }
        System.out.println(Math.min(two, five));
    }
}