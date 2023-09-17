import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            int[] priority = new int[10];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i] = n;
                priority[n] += 1;
            }

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                queue.add(i);
            }

            int cnt = 0;
            int maxPriority = nextPriority(priority);
            while (!queue.isEmpty()) {
                final Integer head = queue.poll();
                if (arr[head] < maxPriority) {
                    queue.add(head);
                } else {
                    cnt++;
                    if (head == M) {
                        break;
                    }
                    maxPriority = nextPriority(priority);
                }
            }
            System.out.println(cnt);
        }
    }

    private static int nextPriority(int[] priority) {
        for (int i = 9; i >= 0; i--) {
            if (priority[i] > 0) {
                priority[i] -= 1;
                return i;
            }
        }
        return 0;
    }
}