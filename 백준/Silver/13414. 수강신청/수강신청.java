import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                set.remove(str);
            }
            set.add(str);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str: set) {
            if (i++ >= K) {
                break;
            }
            sb.append(str).append('\n');
        }
        System.out.print(sb);
    }
}
