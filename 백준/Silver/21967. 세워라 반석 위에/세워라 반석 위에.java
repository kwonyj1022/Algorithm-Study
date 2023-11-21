import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqD = new PriorityQueue<>(Comparator.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = 0;
        int e = 0;
        int len = 0;
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            pqA.add(input[i]);
            pqD.add(input[i]);
            e = i;
            if (Math.max(input[i], pqD.peek()) - Math.min(input[i], pqA.peek()) > 2) {
                pqA.remove(input[s]);
                pqD.remove(input[s]);
                s++;
            }
            len = Math.max(len, e - s + 1);
        }
        System.out.println(len);
    }
}