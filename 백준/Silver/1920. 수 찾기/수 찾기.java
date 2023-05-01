import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> A = new HashMap<>();
        String[] inputA = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(inputA[i]);
            if (!A.containsKey(a)) {
                A.put(a, 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        String[] inputB = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int b = Integer.parseInt(inputB[i]);
            if (A.containsKey(b)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}