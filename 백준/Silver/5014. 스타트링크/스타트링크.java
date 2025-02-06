import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        F = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);
        U = Integer.parseInt(input[3]);
        D = Integer.parseInt(input[4]);
        boolean[] visited = new boolean[F + 1];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(S, 0));
        visited[S] = true;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (poll.floor == G) {
                System.out.print(poll.cnt);
                return;
            }
            int up = poll.floor + U;
            int down = poll.floor - D;
            if (up <= F && !visited[up]) {
                visited[up] = true;
                q.offer(new Node(up, poll.cnt + 1));
            }
            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                q.offer(new Node(down, poll.cnt + 1));
            }
        }
        System.out.print("use the stairs");
    }

    static class Node {
        int floor;
        int cnt;

        Node(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }
}
