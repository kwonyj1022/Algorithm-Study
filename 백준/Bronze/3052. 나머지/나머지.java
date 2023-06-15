import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Integer> r = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            r.add(n % 42);
        }

        System.out.println(r.size());
    }
}