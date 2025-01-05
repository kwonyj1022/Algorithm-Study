import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
            int n = dq.pollFirst();
            sb.append(n).append(" ");
            if (dq.isEmpty()) {
                break;
            }
            if (arr[n] > 0) {
                for (int i = 1; i < arr[n]; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i < -arr[n]; i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }
        System.out.print(sb);
    }
}
