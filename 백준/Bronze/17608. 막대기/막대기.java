import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int last = arr[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] > last) {
                answer++;
                last = arr[i];
            }
        }
        System.out.print(answer + 1);
    }
}
