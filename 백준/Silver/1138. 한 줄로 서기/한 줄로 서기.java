import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        int[] answer = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        answer[arr[1]] = 1;
        for (int i = 2; i <= N; i++) {
            int pos = arr[i];
            for (int j = 0; j <= pos; j++) {
                if (answer[j] != 0) {
                    pos++;
                }
            }
            answer[pos] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb);
    }
}
