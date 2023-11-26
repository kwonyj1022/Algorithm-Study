import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static Set<String> answers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        f(n, "");
        List<String> al = answers.stream().collect(Collectors.toList());

        al.sort(Comparator.naturalOrder());

        if (k > al.size()) {
            System.out.println(-1);
            return;
        }
        String answer = al.get(k - 1);
        int t = answer.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(answer.charAt(i)).append("+");
        }
        sb.append(answer.charAt(t));

        System.out.println(sb);
    }

    private static void f(int n, String str) {
        if (n == 1) {
            answers.add(str.concat("1"));
        } else if (n == 2) {
            answers.add(str.concat("2"));
            f(n - 1, str.concat("1"));
        } else if (n == 3) {
            answers.add(str.concat("3"));
            f(n - 2, str.concat("2"));
            f(n - 1, str.concat("1"));
        } else {
            f(n - 3, str.concat("3"));
            f(n - 2, str.concat("2"));
            f(n - 1, str.concat("1"));
        }
    }
}