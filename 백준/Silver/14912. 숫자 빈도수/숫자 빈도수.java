import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int answer = 0;
        for(int i=0; i<=n; i++) {
        	int num = i;
        	while(num != 0) {
        		if(num % 10 == d){
            		answer++;
            	}
        		num /= 10;
        	}
        }
        System.out.print(answer);
	}
}
