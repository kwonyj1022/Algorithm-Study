import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int t = N;
        int answer = 0;
        while (true) {
            t = next(t);
            answer++;
            if (t == N) {
                break;
            }
        }
        System.out.println(answer);
    }

    static int next(int n) {
        if (n < 10) {
            return n * 10 + n;
        }
        return (n % 10) * 10 + (n / 10 + n % 10) % 10;
    }
}
