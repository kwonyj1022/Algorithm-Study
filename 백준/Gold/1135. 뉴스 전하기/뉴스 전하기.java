import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static List<Integer>[] tree;
    static int head;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int root = Integer.parseInt(input[i]);
            if (root == -1) {
                head = i;
            } else {
                tree[root].add(i);
            }
        }

        System.out.print(solve(head));
    }

    static int solve(int node) {
        if (tree[node].size() == 0) {
            return 0;
        }

        List<Integer> times = new ArrayList<>();
        for (int child : tree[node]) {
            times.add(solve(child));
        }

        Collections.sort(times, Collections.reverseOrder());

        int max = 0;
        for (int i = 0; i < times.size(); i++) {
            max = Math.max(max, times.get(i) + i + 1);
        }

        return max;
    }
}
