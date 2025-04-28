import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());		
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(0);
		for(int i = 1 ; i < N+1 ; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr.add(i - num, i);
		}		
		for(int i = 1 ; i < N +1 ; i++) {
			System.out.print(arr.get(i)+ " ");
		}		
	}
}
