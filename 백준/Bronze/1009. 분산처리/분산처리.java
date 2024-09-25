import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = 0;
            int answer = 1;

            int tmp = a % 10;
            if (tmp == 0 || tmp == 1 || tmp == 5 || tmp == 6) {
                answer = tmp;
            } else if (tmp == 4 || tmp == 9) {
                c = b % 2;
                if (c == 0) {
                    c = 2;
                }
            } else {
                c = b % 4;
                if (c == 0) {
                    c = 4;
                }
            }

            for (int i = 0; i < c; i++) {
                answer = (answer * a) % 10;
            }

            if (answer == 0) {
                answer = 10;
            }

            System.out.println(answer);
        }
        sc.close();
    }
}
