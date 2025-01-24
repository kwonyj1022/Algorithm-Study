import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 4;
        int[][] arr = new int[101][101];
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i = x1; i < x2; i++) {
                for(int j = y1; j < y2; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                sum += arr[i][j];
            }
        }

        System.out.print(sum);
    }
}
