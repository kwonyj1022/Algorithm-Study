import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if (N == 0) {
            System.out.print(1);
            return;
        }
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arrSize = Math.max(N, P);
        int[] arr = new int[arrSize];
        int answer = 1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > score) {
                answer++;
            }
        }
        if (N < P || arr[P - 1] < score) {
            System.out.print(answer);
        } else {
            System.out.print(-1);
        }
    }
}
