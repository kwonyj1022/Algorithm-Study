import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        if ((M == 1 || M == 2) && N >= 2) {
            sb.append("2\n");
        }

        if (M % 2 == 0) {
            M++;
        }

        for (int i = M; i <= N; i += 2) {
            if (i == 3) {
                sb.append("3\n");
                continue;
            }
            long t = 2;
            while (t * t < i) {
                if (i % t == 0) {
                    break;
                }
                if ((t + 1) * (t + 1) > i) {
                    sb.append(i).append("\n");
                }

                t++;
            }
        }
        System.out.println(sb);
    }
}