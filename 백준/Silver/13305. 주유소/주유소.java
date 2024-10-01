import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] length = new int[N - 1];
        int[] cost = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        long answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            min = Math.min(min, Integer.parseInt(st.nextToken()));
            answer += (long) min * length[i];
        }
        System.out.print(answer);
    }
}