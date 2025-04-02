import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet();
        set.add("ChongChong");
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String A, B;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = st.nextToken();
            B = st.nextToken();

            if (set.contains(A) || set.contains(B)) {
                set.add(A);
                set.add(B);
            }
        }

        System.out.print(set.size());
    }
}
