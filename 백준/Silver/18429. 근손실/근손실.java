import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static int N, K;
    static int[] A;
    static boolean[] visited;
    static int sum = 500;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        solve(0);
        System.out.print(answer);
	}

    static void solve(int depth) {
        if (depth == N) {
            if (sum >= 500) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sum -= K;
            sum += A[i];
            if (sum < 500) {
                sum += K;
                sum -= A[i];
                visited[i] = false;
                continue;
            }
            solve(depth + 1);
            sum += K;
            sum -= A[i];
            visited[i] = false;
        }
    }
}
