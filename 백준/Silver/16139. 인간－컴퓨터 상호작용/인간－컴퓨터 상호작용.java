import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int len = S.length();
        int[][] arr = new int[26][len];
        arr[S.charAt(0) - 'a'][0] = 1;
        for (int i = 1; i < len; i++) {
            int t = S.charAt(i) - 'a';
            arr[t][i] = arr[t][i - 1] + 1;
            for (int j = 0; j < 26; j++) {
                if (j == t) {
                    continue;
                }
                arr[j][i] = arr[j][i - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(arr[a][r] - (l > 0 ? arr[a][l - 1] : 0)).append('\n');
        }
        System.out.print(sb);
    }
}
