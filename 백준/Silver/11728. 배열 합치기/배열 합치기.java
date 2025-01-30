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
        int[] narr = new int[N];
        int[] marr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            narr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            marr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int ni = 0;
        int mi = 0;
        while (ni < N && mi < M) {
            if (narr[ni] < marr[mi]) {
                sb.append(narr[ni++]).append(" ");
            } else {
                sb.append(marr[mi++]).append(" ");
            }
        }
        while (ni < N) {
            sb.append(narr[ni++]).append(" ");
        }
        while (mi < M) {
            sb.append(marr[mi++]).append(" ");
        }
        System.out.print(sb);
    }
}
