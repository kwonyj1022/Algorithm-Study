import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Main {
    static int N;
    static String[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new String[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = br.readLine();
        }
        Arrays.sort(numbers, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            int o1hap = hap(o1);
            int o2hap = hap(o2);
            if (o1hap != o2hap) {
                return o1hap - o2hap;
            }
            return o1.compareTo(o2);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(numbers[i]).append('\n');
        }
        System.out.print(sb);
    }

    static int hap(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sum += str.charAt(i) - '0';
            }
        }
        return sum;
    }
}
