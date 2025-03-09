import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] board = new int[N];
        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }
        int[] trial = new int[M];
        for (int i = 0; i < M; i++) {
            trial[i] = Integer.parseInt(br.readLine());
        }
        int cursor = 0;
        int cnt = 0;
        while (cursor < N - 1) {
            cursor += trial[cnt++];
            if (cursor >= N - 1) {
                break;
            }
            cursor += board[cursor];
        }
        System.out.print(cnt);
    }
}
