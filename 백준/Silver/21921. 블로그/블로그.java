import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long answer = 0;
        long sum = 0;
        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }
        answer = sum;
        int cnt = 1;
        int l = 0;
        for (int i = X; i < N; i++) {
            sum = sum - arr[l] + arr[i];
            if (answer == sum) {
                cnt++;
            } else if (sum > answer) {
                cnt = 1;
                answer = sum;
            }
            l++;
        }
        StringBuilder sb = new StringBuilder();
        if (answer == 0) {
            sb.append("SAD");
        } else {
            sb.append(answer).append('\n').append(cnt);
        }
        System.out.print(sb);
	}
}
