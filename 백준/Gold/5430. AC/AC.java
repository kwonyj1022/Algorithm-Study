import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input.substring(1, input.length() - 1), ",");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean r = false;
            boolean error = false;
            int start = 0;
            int end = n - 1;
            int flen = p.length();
            for (int i = 0; i < flen; i++) {
                if (p.charAt(i) == 'R') {
                    if (r) {
                        r = false;
                    } else {
                        r = true;
                    }
                } else {
                    if (start > end) {
                        error = true;
                        break;
                    }
                    if (r) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                if (start > end) {
                    sb.append("[]\n");
                    continue;
                }
                sb.append("[");
                if (r) {
                    for (int i = end; i > start; i--) {
                        sb.append(arr[i]).append(",");
                    }
                    sb.append(arr[start]).append("]\n");
                } else {
                    for (int i = start; i < end; i++) {
                        sb.append(arr[i]).append(",");
                    }
                    sb.append(arr[end]).append("]\n");
                }
            }
        }
        System.out.println(sb);
    }
}