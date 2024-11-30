import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());
            while (true) {
                if (stack.isEmpty()) {
                    sb.append("0 ");
                    stack.push(new Node(i, h));
                    break;
                }
                if (stack.peek().height >= h) {
                    sb.append(stack.peek().num).append(" ");
                    stack.push(new Node(i, h));
                    break;
                }
                stack.pop();
            }
        }
        System.out.print(sb);
    }

    static class Node {
        int num;
        int height;

        public Node(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }
}
