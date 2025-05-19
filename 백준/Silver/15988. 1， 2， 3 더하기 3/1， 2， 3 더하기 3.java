import java.io.*;
import java.util.*;

public class Main {

    static int[] arr = new int[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
		for (int i = 4; i < 1000001; i++) {
            for (int j = 1; j <= 3; j++) {
                arr[i] = (arr[i] + arr[i - j]) % 1000000009;
            }
        }
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append('\n');
        }
        System.out.print(sb);
	}
}
