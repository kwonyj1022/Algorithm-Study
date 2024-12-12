import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            arr[i] = input.toCharArray();
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            boolean[] friend = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'Y') {
                    friend[j] = true;
                    for (int k = 0; k < N; k++) {
                        if (arr[j][k] == 'Y') {
                            friend[k] = true;
                        }
                    }
                }
            }
            friend[i] = false;
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (friend[j]) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.print(answer);
    }
}
