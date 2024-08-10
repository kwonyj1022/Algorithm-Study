import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double A = sc.nextLong();
        double B = sc.nextLong();
        boolean[] notSosu = new boolean[10000001];
        for (int i = 2; i < 10000001; i++) {
            if (notSosu[i]) {
                continue;
            }
            for (int j = i + i; j < 10000001; j += i) {
                notSosu[j] = true;
            }
        }
        int cnt = 0;
        for (int i = 2; i < 10000001; i++) {
            if (notSosu[i]) {
                continue;
            }
            long tmp = i;
            while (i <= (double) B / tmp) {
                if (i >= (double) A / tmp) {
                    cnt++;
                }
                tmp *= i;
            }
        }
        System.out.print(cnt);
    }
}