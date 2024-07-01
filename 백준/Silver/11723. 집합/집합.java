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
        boolean[] bit = new boolean[21];
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String act = st.nextToken();
            int x = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
            if ("add".equals(act)) {
                bit[x] = true;
            } else if ("remove".equals(act)) {
                bit[x] = false;
            } else if ("check".equals(act)) {
                bw.write(bit[x] ? "1\n" : "0\n");
            } else if ("toggle".equals(act)) {
                bit[x] = bit[x] ? false : true;
            } else if ("all".equals(act)) {
                for (int i = 1; i < 21; i++) {
                    bit[i] = true;
                }
            } else if ("empty".equals(act)) {
                for (int i = 1; i < 21; i++) {
                    bit[i] = false;
                }
            }
        }
        bw.flush();
    }
}