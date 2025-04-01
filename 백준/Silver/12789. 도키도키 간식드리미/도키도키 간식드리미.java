import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(input[i]));
        }
        Stack<Integer> stack = new Stack<>();
        int next = 1;
        while (!q.isEmpty()) {
            if (q.peek() == next) {
                q.poll();
                next++;
            } else if (!stack.isEmpty() && stack.peek() == next) {
                stack.pop();
                next++;
            } else {
                stack.push(q.poll());
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != next) {
                System.out.print("Sad");
                return;
            }
            next++;
        }
        System.out.print("Nice");
    }
}
