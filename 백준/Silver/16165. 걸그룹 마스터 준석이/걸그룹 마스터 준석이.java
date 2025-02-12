import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Map<String, String> nameGroup = new HashMap<>();
        Map<String, List<String>> groupNames = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String group = br.readLine();
            List<String> names = new ArrayList<>();
            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < cnt; j++) {
                String name = br.readLine();
                nameGroup.put(name, group);
                names.add(name);
            }
            groupNames.put(group, names);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            String type = br.readLine();
            if (type.charAt(0) == '0') {
                List<String> names = groupNames.get(question);
                Collections.sort(names);
                for(String name: names) {
                    sb.append(name).append("\n");
                }
            } else {
                sb.append(nameGroup.get(question)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
