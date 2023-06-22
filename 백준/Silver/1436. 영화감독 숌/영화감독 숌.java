import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = 0;
        int answer = 665;
        while (i < N) {
            answer++;
            if (String.valueOf(answer).contains("666")) {
                i++;
            }
        }
        System.out.println(answer);
    }
}