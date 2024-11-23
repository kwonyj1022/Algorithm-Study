import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minA = Math.min(minA, Integer.parseInt(st.nextToken()));
            minB = Math.min(minB, Integer.parseInt(st.nextToken()));
        }
        if (minA > minB * 6) {
            System.out.print(minB * N);
        } else if (N % 6 * minB > minA) {
            System.out.print((N / 6 + 1) * minA);
        } else {
            System.out.print(N / 6 * minA + N % 6 * minB);
        }
    }
}
