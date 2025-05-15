import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		double max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
		}
        
		double answer = max;
		for (int i = 0; i < N; i++) {
			if (arr[i] == max) {
				continue;
            }
            
			answer += arr[i] / 2;
		}
        
		System.out.print(answer);
	}
}
