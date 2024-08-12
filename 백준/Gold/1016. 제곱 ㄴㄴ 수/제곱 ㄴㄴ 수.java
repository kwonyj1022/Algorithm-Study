import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        int range = (int) (max - min) + 1;
        boolean[] jegob = new boolean[range];
        for (long i = 2; i * i <= max; i++) {
            long gob = i * i;
            long t = min % gob == 0 ? min / gob : min / gob + 1;
            for (long j = t; j * gob <= max; j++) {
                jegob[(int) (j * gob - min)] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i < range; i++) {
            if (!jegob[i]) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
