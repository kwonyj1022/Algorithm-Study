import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (char c : input.toCharArray()) {
            left.push(c);
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].charAt(0) == 'L') {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (command[0].charAt(0) == 'D') {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (command[0].charAt(0) == 'B') {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else {
                left.push(command[1].charAt(0));
            }
        }
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.print(sb);
    }
}
