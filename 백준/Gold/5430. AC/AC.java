import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> dq = new ArrayDeque<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input.substring(1, input.length() - 1), ",");
            for (int i = 0; i < n; i++) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }
            boolean forward = true;
            boolean error = false;
            int flen = p.length();
            for (int i = 0; i < flen; i++) {
                if (p.charAt(i) == 'R') {
                    if (forward) {
                        forward = false;
                    } else {
                        forward = true;
                    }
                } else {
                    if (dq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (forward) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                if (dq.isEmpty()) {
                    sb.append("[]\n");
                    continue;
                }
                int t = dq.size() - 1;
                sb.append("[");
                if (forward) {
                    for (int i = 0; i < t; i++) {
                        sb.append(dq.pollFirst()).append(",");
                    }
                    sb.append(dq.pollFirst()).append("]\n");
                } else {
                    for (int i = 0; i < t; i++) {
                        sb.append(dq.pollLast()).append(",");
                    }
                    sb.append(dq.pollLast()).append("]\n");
                }
            }
        }
        System.out.println(sb);
    }
}