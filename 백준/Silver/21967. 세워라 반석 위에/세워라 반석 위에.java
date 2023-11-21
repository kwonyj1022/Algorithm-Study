import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int[] arr = new int[11];
        int min = 0;
        int max = 0;
        int s = 0;
        int len = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            arr[input[i]]++;
            for (int j = 1; j < 11; j++) {
                if (arr[j] > 0) {
                    min = j;
                    break;
                }
            }
            for (int j = 10; j > 0; j--) {
                if (arr[j] > 0) {
                    max = j;
                    break;
                }
            }

            if (max - min > 2) {
                arr[input[s]]--;
                s++;
            }
            len = Math.max(len, i - s + 1);
        }
        System.out.println(len);
    }
}