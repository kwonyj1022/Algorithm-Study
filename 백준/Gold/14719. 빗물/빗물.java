import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[W];
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int answer = 0;
        for(int i = 1; i < W - 1; i++) {
            left = Math.max(left, arr[i - 1]);
            int right = 0;
            for(int j = i + 1; j < W; j++) {
                right = Math.max(arr[j], right);
            }

            int h = Math.min(left, right);
            answer += Math.max(0, h - arr[i]);
        }
        System.out.println(answer);
    }
}
