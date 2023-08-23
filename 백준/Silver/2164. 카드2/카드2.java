import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        while (q.size() > 1) {
            q.remove();
            q.add(q.remove());
        }

        System.out.println(q.remove());
    }
}