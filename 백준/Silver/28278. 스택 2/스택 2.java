import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (cmd == 2) {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.pop()).append('\n');
                }
            } else if (cmd == 3) {
                sb.append(stack.size()).append('\n');
            } else if (cmd == 4) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd == 5) {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.peek()).append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
