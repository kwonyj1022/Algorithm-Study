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
        int bit = 0;
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String act = st.nextToken();
            int x = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
            if ("add".equals(act)) {
                bit |= 1 << x;
            } else if ("remove".equals(act)) {
                bit &= ~(1 << x);
            } else if ("check".equals(act)) {
                bw.write((bit & 1 << x) == 0 ? "0\n" : "1\n");
            } else if ("toggle".equals(act)) {
                if ((bit & 1 << x) == 0) {
                    bit |= 1 << x;
                } else {
                    bit &= ~(1 << x);
                }
            } else if ("all".equals(act)) {
                bit = 0b111111111111111111111;
            } else if ("empty".equals(act)) {
                bit = 0;
            }
        }
        bw.flush();
    }
}