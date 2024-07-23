import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int t = 2;
        while (t <= N) {
            if (N % t == 0) {
                N /= t;
                sb.append(t).append("\n");
            } else {
                t++;
            }
        }
        System.out.print(sb);
    }
}
