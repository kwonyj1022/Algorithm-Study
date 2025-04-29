import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] <= end) {
                continue;
            }
            end = arr[i] + L - 1;
            answer++;
        }
        System.out.print(answer);
	}
}
