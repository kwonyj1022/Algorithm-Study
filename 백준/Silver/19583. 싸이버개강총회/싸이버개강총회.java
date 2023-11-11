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
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> tmp = new HashSet<>();
        Set<String> ok = new HashSet<>();
        while (true) {
            final String s = br.readLine();
            if (s == null) {
                break;
            }
            st = new StringTokenizer(s);
            String time = st.nextToken();
            String name = st.nextToken();
            if (time.compareTo(S) <= 0) {
                tmp.add(name);
            } else if (E.compareTo(time) <= 0 && time.compareTo(Q) <= 0 && tmp.contains(name)) {
                ok.add(name);
            }
        }

        System.out.println(ok.size());
    }
}