import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        char type = input[1].charAt(0);
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        if (type == 'Y') {
            System.out.print(set.size());
        } else if (type == 'F') {
            System.out.print(set.size() / 2);
        } else {
            System.out.print(set.size()/ 3);
        }
    }
}
