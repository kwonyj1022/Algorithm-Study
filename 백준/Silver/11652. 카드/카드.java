import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Long, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            long n = Long.parseLong(br.readLine());
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }
        long answer = 0;
        int maxCount = 0;
        for (long n: map.keySet()) {
            int cnt = map.get(n);
            if (cnt > maxCount) {
                answer = n;
                maxCount = cnt;
            } else if (cnt == maxCount && n < answer) {
                answer = n;
            }
        }
        System.out.print(answer);
	}
}
