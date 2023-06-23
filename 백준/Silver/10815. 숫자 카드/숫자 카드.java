import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken()) + 10000000] = true;
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            sb.append(arr[Integer.parseInt(st.nextToken()) + 10000000] ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }
}