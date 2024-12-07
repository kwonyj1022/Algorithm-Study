import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] students = new String[N];
        for (int i = 0; i < N; i++) {
            students[i] = br.readLine();
        }

        for (int answer = 1; answer <= 100; answer++) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(students[i].substring(students[i].length() - answer));
            }
            if (set.size() == N) {
                System.out.print(answer);
                break;
            }
        }
    }
}
