import java.util.*;
import java.io.*;

public class Main {

    static char[][] wheel;
    static int[] idx;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheel = new char[4][8];
        idx = new int[4];
        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            wheel[i] = br.readLine().toCharArray();
        }
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);
            turn(n - 1, d, 0);
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (wheel[i][idx[i]] == '1') {
                answer += (1 << i);
            }
        }
        System.out.print(answer);
    }

    static void turn(int n, int d, int flag) {
        if (flag <= 0 && n > 0 && wheel[n - 1][(idx[n - 1] + 2) % 8] != wheel[n][(idx[n] + 6) % 8]) {
            turn(n - 1, -d, -1);
        }
        if (flag >= 0 && n < 3 && wheel[n][(idx[n] + 2) % 8] != wheel[n + 1][(idx[n + 1] + 6) % 8]) {
            turn(n + 1, -d, 1);
        }
        if (d == 1) {
            idx[n] = (idx[n] + 7) % 8;
        } else {
            idx[n] = (idx[n] + 1) % 8;
        }
    }
}
