import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                return;
            }
            List<Integer> arr = new ArrayList<>();
            for (int t = 1; t < n; t++) {
                if (n % t == 0) {
                    arr.add(t);
                }
            }
            int sum = arr.stream().mapToInt(t -> t).sum();
            StringBuffer sb = new StringBuffer();
            if (sum == n) {
                sb.append(n).append(" = ");
                sb.append(arr.stream().map(t -> t.toString()).collect(Collectors.joining(" + ")));
                System.out.println(sb);
            } else {
                sb.append(n).append(" is NOT perfect.");
                System.out.println(sb);
            }
        }
    }
}