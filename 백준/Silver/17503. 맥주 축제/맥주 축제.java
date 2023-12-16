import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int likeSum = 0;
        int answer = -1;
        for (int i = 0; i < N; i++) {
            likeSum += arr[i][0];
            pq.add(arr[i][0]);
        }

        if (likeSum >= M) {
            System.out.println(arr[N - 1][1]);
            return;
        }

        for (int i = N; i < K; i++) {
            likeSum -= pq.poll();
            likeSum += arr[i][0];
            pq.add(arr[i][0]);

            if (likeSum >= M) {
                answer = arr[i][1];
                break;
            }
        }

        System.out.println(answer);
    }
}