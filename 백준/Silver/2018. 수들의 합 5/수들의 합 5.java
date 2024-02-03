import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int from = 1;
        int to = 1;
        int sum = 1;
        int answer = 1;
        while (to < N) {
            if (sum == N) {
                answer++;
                to++;
                sum += to;
            } else if (sum < N) {
                to++;
                sum += to;
            } else {
                sum -= from;
                from++;
            }
        }

        System.out.println(answer);
    }
}