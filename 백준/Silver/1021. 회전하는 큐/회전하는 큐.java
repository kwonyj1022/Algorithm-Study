import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            int targetIdx = dq.indexOf(arr[i]);
            int midIdx = dq.size() / 2;
            if (dq.size() % 2 == 0) {
                midIdx = midIdx - 1;
            }
            if (targetIdx <= midIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    dq.addLast(dq.pollFirst());
                    answer++;
                }
            } else {
                for (int j = dq.size() - 1; j >= targetIdx; j--) {
                    dq.addFirst(dq.pollLast());
                    answer++;
                }
            }

            dq.pollFirst();
        }
        System.out.print(answer);
    }
}
