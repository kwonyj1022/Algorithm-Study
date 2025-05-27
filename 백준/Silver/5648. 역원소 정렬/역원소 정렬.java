import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> list = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        while (list.size() < n) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            } else {
                list.add(Long.parseLong(new StringBuilder(st.nextToken()).reverse().toString()));
            }
        }
        
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (long num : list) {
            sb.append(num).append('\n');
        }
        System.out.print(sb);
	}
}
