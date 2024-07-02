import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] s = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int ts = 0;
        for(int i = 0; i < 6; i++) {
            if (s[i] % T == 0) {
                ts += s[i] / T;
            } else {
                ts += s[i] / T + 1;
            }
        }

        bw.write(String.format("%d\n%d %d", ts, N / P, N % P));
        bw.flush();
        br.close();
        bw.close();
    }
}