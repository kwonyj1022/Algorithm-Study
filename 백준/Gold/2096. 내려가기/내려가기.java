import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] max = new int[N][3];
        int[][] min = new int[N][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int t = Integer.parseInt(st.nextToken());
            max[0][i] = t;
            min[0][i] = t;
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = i - 1;

            int t = Integer.parseInt(st.nextToken());
            max[i][0] = Math.max(max[pre][0], max[pre][1]) + t;
            min[i][0] = Math.min(min[pre][0], min[pre][1]) + t;

            t = Integer.parseInt(st.nextToken());
            max[i][1] = Math.max(max[pre][0], Math.max(max[pre][1], max[pre][2])) + t;
            min[i][1] = Math.min(min[pre][0], Math.min(min[pre][1], min[pre][2])) + t;

            t = Integer.parseInt(st.nextToken());
            max[i][2] = Math.max(max[pre][1], max[pre][2]) + t;
            min[i][2] = Math.min(min[pre][1], min[pre][2]) + t;
        }
        
        N--;
        System.out.print(Math.max(max[N][0], Math.max(max[N][1], max[N][2])) + " " + Math.min(min[N][0], Math.min(min[N][1], min[N][2])));
    }
}
