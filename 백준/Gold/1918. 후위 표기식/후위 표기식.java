import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Stack<Character> operation = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : input) {
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
                continue;
            }
            if (c == '(') {
                operation.push('(');
            } else if (c == ')') {
                while (!operation.isEmpty() && operation.peek() != '(') {
                    sb.append(operation.pop());
                }
                operation.pop();
            } else if (c == '*' || c == '/') {
                while (!operation.isEmpty() && operation.peek() != '+' && operation.peek() != '-' && operation.peek() != '(') {
                    sb.append(operation.pop());
                }
                operation.push(c);
            } else {
                while (!operation.isEmpty() && operation.peek() != '(') {
                    sb.append(operation.pop());
                }
                operation.push(c);
            }
        }

        while (!operation.isEmpty()) {
            sb.append(operation.pop());
        }
        System.out.print(sb);
    }
}
