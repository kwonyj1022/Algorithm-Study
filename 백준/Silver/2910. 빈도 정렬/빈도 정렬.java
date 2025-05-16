import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, Num> map;
    static Num[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        arr = new Num[N];
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (map.containsKey(n)) {
                map.get(n).cnt++;
            } else {
                Num num = new Num(n, 1, idx);
                map.put(n, num);
                arr[idx] = num;
                idx++;
            }
        }
        Arrays.sort(arr, 0, idx, (o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                return o1.idx - o2.idx;
            }
            return o2.cnt - o1.cnt;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < arr[i].cnt; j++) {
                sb.append(arr[i].num).append(' ');
            }
        }
        System.out.print(sb);
	}

    static class Num {
        int num;
        int cnt;
        int idx;

        Num(int num, int cnt, int idx) {
            this.num = num;
            this.cnt = cnt;
            this.idx = idx;
        }
    }
}
