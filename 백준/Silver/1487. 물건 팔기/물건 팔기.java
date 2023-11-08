import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        int maxPrice = 0;
        int maxProfit = 0;
        for (int i = 0; i < N; i++) {
            if (i != 0 && arr[i][0] == arr[i - 1][0]) {
                continue;
            }
            int sum = 0;
            for (int j = i; j < N; j++) {
                int tmp = arr[i][0] - arr[j][1];
                if (tmp > 0) {
                    sum += tmp;
                }
            }
            if (sum > maxProfit) {
                maxPrice = arr[i][0];
                maxProfit = sum;
            }
        }

        System.out.println(maxPrice);
    }
}