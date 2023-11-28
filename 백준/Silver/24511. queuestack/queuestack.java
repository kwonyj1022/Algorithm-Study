import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] isQueue = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (st.nextToken().equals("0")) {
                isQueue[i] = true;
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            if (isQueue[i]) {
                queue.offer(data[i]);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(queue.poll()).append(" ");
        }
        System.out.println(sb);
    }
}