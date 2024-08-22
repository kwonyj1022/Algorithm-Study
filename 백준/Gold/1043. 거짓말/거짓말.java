import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[N + 1][M];
        boolean[] visitedPeople = new boolean[N + 1];
        boolean[] visitedParty = new boolean[M];
        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < tc; i++) {
            int tp = Integer.parseInt(st.nextToken());
            q.offer(tp);
            visitedPeople[tp] = true;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pc = Integer.parseInt(st.nextToken());
            for (int j = 0; j < pc; j++) {
                arr[Integer.parseInt(st.nextToken())][i] = true;
            }
        }

        while (!q.isEmpty()) {
            int tp = q.poll();
            for (int i = 0; i < M; i++) {
                if (arr[tp][i] && !visitedParty[i]) {
                    visitedParty[i] = true;
                    for (int j = 1; j <= N; j++) {
                        if (arr[j][i] && !visitedPeople[j]) {
                            q.offer(j);
                            visitedPeople[j] = true;
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (!visitedParty[i]) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
