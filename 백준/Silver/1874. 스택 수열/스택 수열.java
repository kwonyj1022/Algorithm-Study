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
        int num = 1;
        while(n-- > 0) {
            int t = Integer.parseInt(br.readLine());
            if (t >= num) {
                while (t >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int top = stack.pop();
                if (top == t) {
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}