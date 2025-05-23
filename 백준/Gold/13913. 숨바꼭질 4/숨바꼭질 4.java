import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new ArrayDeque<>();
        int[] parent = new int[100001];
        q.offer(new int[]{N, 0});
        parent[N] = -1;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (poll[0] == K) {
                sb.append(poll[1]).append('\n');
                break;
            }
            visited.add(poll[0]);
            int nextT = poll[1] + 1;
            int[] nextPositions = {poll[0] - 1, poll[0] + 1, poll[0] * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited.contains(next)) {
                    visited.add(next);
                    q.offer(new int[]{next, poll[1] + 1});
                    parent[next] = poll[0];
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        int cur = K;
        while (cur != -1) {
            stack.add(cur);
            cur = parent[cur];
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.print(sb);
	}
}
