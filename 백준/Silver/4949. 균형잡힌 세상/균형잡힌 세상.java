import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            int len = s.length();
            Stack<Character> st = new Stack<>();
            boolean isYes = true;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '(') {
                    st.push('(');
                } else if (s.charAt(i) == ')') {
                    if (st.isEmpty() || (!st.isEmpty() && st.pop() != '(')) {
                        sb.append("no\n");
                        isYes = false;
                        break;
                    }
                } else if (s.charAt(i) == '[') {
                    st.push('[');
                } else if (s.charAt(i) == ']') {
                    if (st.isEmpty() || (!st.isEmpty() && st.pop() != '[')) {
                        sb.append("no\n");
                        isYes = false;
                        break;
                    }
                }
            }
            if (isYes && st.isEmpty()) {
                sb.append("yes\n");
            } else if (isYes && !st.isEmpty()){
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}