import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.charAt(1) == 'u') {
                dq.add(Integer.parseInt(st.nextToken()));
            } else if (cmd.charAt(1) == 'o') {
                sb.append(dq.isEmpty() ? -1 : dq.removeFirst()).append('\n');
            } else if (cmd.charAt(1) == 'i') {
                sb.append(dq.size()).append('\n');
            } else if (cmd.charAt(1) == 'm') {
                sb.append(dq.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd.charAt(1) == 'r') {
                sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
            } else if (cmd.charAt(1) == 'a') {
                sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
