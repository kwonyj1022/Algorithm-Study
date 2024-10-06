import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] A;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        tmp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);
        if (K > 0) {
            System.out.print(-1);
        }
    }

    static void mergeSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, m, r);
    }

    static void merge(int l, int m, int r) {
        if (K == 0) {
            return;
        }
        int i = l;
        int j = m + 1;
        int t = 0;

        while (i <= m && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }
        while (i <= m) {
            tmp[t++] = A[i++];
        }
        while (j <= r) {
            tmp[t++] = A[j++];
        }
        i = l;
        t = 0;
        while (i <= r) {
            A[i++] = tmp[t++];
            K--;
            if (K == 0) {
                System.out.print(A[i - 1]);
                return;
            }
        }
    }
}
