import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        int amin = 10000;
        int amax = -10000;
        int bmin = 10000;
        int bmax = -10000;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            amin = Math.min(amin, A[i]);
            amax = Math.max(amax, A[i]);
            bmin = Math.min(bmin, B[i]);
            bmax = Math.max(bmax, B[i]);
        }

        System.out.print((amax - amin) * (bmax - bmin));
    }
}
