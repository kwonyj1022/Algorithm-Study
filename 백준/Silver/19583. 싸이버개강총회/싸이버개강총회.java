import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = timeToInt(st.nextToken());
        int E = timeToInt(st.nextToken());
        int Q = timeToInt(st.nextToken());

        Set<String> tmp = new HashSet<>();
        Set<String> ok = new HashSet<>();
        while (true) {
            final String s = br.readLine();
            if (s == null) {
                break;
            }
            st = new StringTokenizer(s);
            int time = timeToInt(st.nextToken());
            String name = st.nextToken();
            if (time <= S) {
                tmp.add(name);
            } else if (E <= time && time <= Q && tmp.contains(name)) {
                ok.add(name);
            }
        }

        System.out.println(ok.size());
    }

    private static int timeToInt(String str) {
        String[] split = str.split(":");
        return Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1]);
    }
}