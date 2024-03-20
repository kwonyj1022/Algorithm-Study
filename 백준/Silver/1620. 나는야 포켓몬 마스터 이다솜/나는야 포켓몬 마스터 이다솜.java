import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] names = new String[N + 1];
        Map<String, Integer> nameNum = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            names[i] = br.readLine();
            nameNum.put(names[i], i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if ('0' <= input.charAt(0) && input.charAt(0) <= '9') {
                sb.append(names[Integer.parseInt(input)]).append("\n");
            } else {
                sb.append(nameNum.get(input)).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}