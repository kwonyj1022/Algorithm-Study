import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int last = 0;
        while (n-- > 0) {
            int t = Integer.parseInt(br.readLine());
            if (stack.empty() || stack.peek() != t) {
                if (last >= t) {
                    System.out.println("NO");
                    return;
                }
                for (int i = last + 1; i <= t; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                last = t;
            }
            if (stack.peek() == t) {
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}