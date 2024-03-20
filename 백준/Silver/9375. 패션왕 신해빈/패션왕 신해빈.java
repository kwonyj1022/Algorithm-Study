import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append("0\n");
                continue;
            }
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            long answer = 1;
            for (final String type : map.keySet()) {
                answer *= (long) map.get(type) + 1;
            }
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}