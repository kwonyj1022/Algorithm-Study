import java.util.Scanner;

public class Main {

    static int N;
    static StringBuilder sb;

    public static void main(String[] args) {
        sb = new StringBuilder();
        N = new Scanner(System.in).nextInt();
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.print(sb);
    }

    static void dfs(int root, int cnt) {
        if (cnt == N) {
            sb.append(root).append("\n");
            return;
        }
        root *= 10;
        cnt++;
        for (int i = 1; i < 10; i++) {
            root++;
            if (isPrime(root)) {
                dfs(root, cnt);
            }
        }
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= n /2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}