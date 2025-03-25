import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tree = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 0;
        for (int i = 0; i < N - 1; i++) {
            gcd = gcd(tree[i + 1] - tree[i], gcd);
        }

        int total = (tree[N - 1] - tree[0]) / gcd + 1;
        System.out.println(total - tree.length);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
