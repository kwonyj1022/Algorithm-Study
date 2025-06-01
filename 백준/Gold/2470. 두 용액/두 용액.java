import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int l = 0;
        int r = N - 1;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (l < r) {
            int sum = arr[l] + arr[r];
            int tmp = Math.abs(sum);
            if (min > tmp) {
                min = tmp;
                left = arr[l];
                right = arr[r];
                if (tmp == 0) {
                    break;
                }
            }
            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
		
		System.out.print(left + " " + right);
	}
}
