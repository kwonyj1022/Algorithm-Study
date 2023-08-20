import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        int answer = 1;
        int n = 1;
        while(n < N) {
            n += 6 * answer++;
        }
        System.out.println(answer);
    }
}