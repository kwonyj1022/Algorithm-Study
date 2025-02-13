import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputArr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isFlag = false;
        for (char c: inputArr) {
            if (c == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(c);
                isFlag = true;
            } else if (c == '>') {
                sb.append(c);
                isFlag = false;
            } else {
                if (isFlag) {
                    sb.append(c);
                } else {
                    if (c == ' ') {
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        sb.append(c);
                    } else {
                        stack.push(c);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.print(sb);
    }
}
