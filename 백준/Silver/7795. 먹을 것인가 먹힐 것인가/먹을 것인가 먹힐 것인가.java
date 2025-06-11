import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);
            int answer = 0;
            for (int j = 0; j < N; j++) {
                int l = 0;
                int r = M - 1;
                int idx = 0;

                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (B[mid] < A[j]) {
                        l = mid + 1;
                        idx = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                answer += idx;
            }
            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }
}
