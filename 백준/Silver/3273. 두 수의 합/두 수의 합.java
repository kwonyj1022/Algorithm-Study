import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        int l = 0;
        int r = n - 1;
        int answer = 0;
        while (0 <= l && l < r && r < n) {
            int t = arr[l] + arr[r];
            if (t == x) {
                answer++;
                l++;
            } else if (t < x) {
                l++;
            } else {
                r--;
            }
        }
        System.out.print(answer);
    }
}
