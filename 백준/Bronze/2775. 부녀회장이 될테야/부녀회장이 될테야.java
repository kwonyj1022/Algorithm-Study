import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[][] cnt = new int[k + 1][n + 1];
            for (int i = 0; i < n + 1; i++) {
                cnt[0][i] = i;
            }

            for (int i = 1; i < k + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    cnt[i][j] = cnt[i][j - 1] + cnt[i - 1][j];
                }
            }

            System.out.println(cnt[k][n]);
        }
    }
}