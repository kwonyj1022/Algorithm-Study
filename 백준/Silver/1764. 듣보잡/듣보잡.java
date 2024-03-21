import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> names = new HashSet<>();
        for (int i = 0; i < N; i++) {
            names.add(br.readLine());
        }
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (names.contains(name)) {
                answers.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answers.size()).append("\n");
        Collections.sort(answers);
        for (String name : answers) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}