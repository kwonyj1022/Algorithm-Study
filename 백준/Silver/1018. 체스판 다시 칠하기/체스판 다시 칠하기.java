import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static String[] str1 = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"};
    public static String[] str2 = {"BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int answer = N * M;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(answer, f(arr, j, i));
            }
        }

        System.out.println(answer);
    }

    public static int f(String[] arr, int x, int y) {
        int t1 = 0;
        for (int i = 0; i < 8; i++) {
            if (arr[i + y].equals(str1[i])) {
                continue;
            }
            for (int j = 0; j < 8; j++) {
                if (arr[i + y].charAt(j + x) != str1[i].charAt(j)) {
                    t1++;
                }
            }
        }
        int t2 = 0;
        for (int i = 0; i < 8; i++) {
            if (arr[i + y].equals(str2[i])) {
                continue;
            }
            for (int j = 0; j < 8; j++) {
                if (arr[i + y].charAt(j + x) != str2[i].charAt(j)) {
                    t2++;
                }
            }
        }
        return Math.min(t1, t2);
    }
}