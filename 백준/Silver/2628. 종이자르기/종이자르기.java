import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[] arr1 = new boolean[a + 1];
        boolean[] arr2 = new boolean[b + 1];
        arr1[0] = true;
        arr1[a] = true;
        arr2[0] = true;
        arr2[b] = true;
        int c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                arr1[Integer.parseInt(st.nextToken())] = true;
            } else {
                arr2[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int amax = 0;
        int prev = 0;
        for (int i = 1; i <= a; i++) {
            if (arr1[i]) {
                amax = Math.max(amax, i - prev);
                prev = i;
            }
        }
        int bmax = 0;
        prev = 0;
        for (int i = 1; i <= b; i++) {
            if (arr2[i]) {
                bmax = Math.max(bmax, i - prev);
                prev = i;
            }
        }
        System.out.println(amax * bmax);
    }
}