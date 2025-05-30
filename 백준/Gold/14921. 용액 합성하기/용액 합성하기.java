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
		int l = 0;
		int r = N - 1;
		int answer = Integer.MAX_VALUE;
		while(l < r) {
			int sum = arr[l] + arr[r];
			if(Math.abs(sum) <= Math.abs(answer)) {
				answer = sum;
			}
			if(sum < 0) {
				l++;
			} else {
				r--;
			}
			
		}
		System.out.print(answer);
	}
}
