import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> str = new HashSet<>();
        for (int i = 0; i < N; i++) {
            str.add(br.readLine());
        }
        String[] arr = str.toArray(new String[str.size()]);

        Arrays.sort(arr);
        Arrays.sort(arr, (o1, o2) -> {
            final int len1 = o1.length();
            final int len2 = o2.length();
            if (len1 > len2) {
                return 1;
            }
            if (len1 < len2) {
                return -1;
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}