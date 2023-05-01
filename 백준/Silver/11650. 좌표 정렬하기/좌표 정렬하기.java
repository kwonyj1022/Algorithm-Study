import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            input[i][0] = Integer.parseInt(row[0]);
            input[i][1] = Integer.parseInt(row[1]);
        }

        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        
        for (int[] row : input) {
            sb.append(row[0]).append(" ").append(row[1]).append("\n");
        }
        System.out.println(sb);
    }
}