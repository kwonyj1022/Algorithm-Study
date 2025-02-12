import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Map<String, String> nameGroup = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String group = br.readLine();
            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < cnt; j++) {
                String name = br.readLine();
                nameGroup.put(name, group);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            String type = br.readLine();
            if (type.charAt(0) == '1') {
                sb.append(nameGroup.get(question)).append("\n");
            } else {
                final List<String> names = new ArrayList<>(nameGroup.keySet());
                Collections.sort(names);
                for (String name: names) {
                    if (nameGroup.get(name).equals(question)) {
                        sb.append(name).append("\n");
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
