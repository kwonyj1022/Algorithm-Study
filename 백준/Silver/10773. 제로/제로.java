import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < K; i++) {
            int t = Integer.parseInt(br.readLine());
            if (t == 0) {
                st.pop();
            } else {
                st.push(t);
            }
        }

        long answer = 0;
        int size = st.size();
        for (int i = 0; i < size; i++) {
            answer += st.pop();
        }
        System.out.println(answer);
    }
}