import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static PriorityQueue<Integer> pqAsc;
    private static PriorityQueue<Integer> pqDesc;
    private static Map<Integer, Integer> count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            pqAsc = new PriorityQueue<>();
            pqDesc = new PriorityQueue<>(Collections.reverseOrder());
            count = new HashMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String t = st.nextToken();
                if (t.equals("I")) {
                    i(Integer.parseInt(st.nextToken()));
                } else {
                    d(Integer.parseInt(st.nextToken()));
                }
            }

            if (count.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sync();
                sb.append(pqDesc.poll()).append(" ").append(pqAsc.poll()).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static void i(int n) {
        count.put(n, count.getOrDefault(n, 0) + 1);
        pqAsc.offer(n);
        pqDesc.offer(n);
    }

    private static void d(int n) {
        if (count.size() == 0) {
            return;
        }
        if (n == -1) {
            while (true) {
                int min = pqAsc.poll();
                int cnt = count.getOrDefault(min, 0);
                if (cnt == 0) {
                    continue;
                }
                if (cnt == 1) {
                    count.remove(min);
                } else {
                    count.put(min, cnt - 1);
                }
                break;
            }
        } else {
            while (true) {
                int max = pqDesc.poll();
                int cnt = count.getOrDefault(max, 0);
                if (cnt == 0) {
                    continue;
                }
                if (cnt == 1) {
                    count.remove(max);
                } else {
                    count.put(max, cnt - 1);
                }
                break;
            }
        }
    }

    private static void sync() {
        while (!count.containsKey(pqAsc.peek())) {
            pqAsc.poll();
        }
        while (!count.containsKey(pqDesc.peek())) {
            pqDesc.poll();
        }
    }
}