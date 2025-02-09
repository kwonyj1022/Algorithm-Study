import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] visited = new int[100001];
        int[] count = new int[100001];

        Queue<Integer> q = new ArrayDeque<>();
        visited[N] = 1;
        count[N] = 1;

        q.offer(N);

        int cnt = 0;

        int[] dx = {1, -1};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean found = false;

            while (size-- > 0) {
                int poll = q.poll();

                if (poll == K) {
                    found = true;
                    cnt += count[poll];
                }

                for (int i = 0; i < 2; i++) {
                    int tmp = poll + dx[i];
                    if (tmp >= 0 && tmp < 100001) {
                        if (visited[tmp] == 0) {
                            visited[tmp] = visited[poll] + 1;
                            count[tmp] = count[poll];
                            q.offer(tmp);
                        } else if (visited[tmp] == visited[poll] + 1) {
                            count[tmp] += count[poll];
                        }
                    }
                }

                int tmp = poll * 2;
                if (tmp >= 0 && tmp < 100001) {
                    if (visited[tmp] == 0) {
                        visited[tmp] = visited[poll] + 1;
                        count[tmp] = count[poll];
                        q.offer(tmp);
                    } else if (visited[tmp] == visited[poll] + 1) {
                        count[tmp] += count[poll];
                    }
                }
            }

            if (found) {
                break;
            }
        }

        System.out.println(visited[K] - 1);
        System.out.println(cnt);
    }
}
