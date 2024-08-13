import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int na = Integer.parseInt(st.nextToken());
        int nb = Integer.parseInt(st.nextToken());
        Set<Integer> A = new HashSet<>();
        Set<Integer> AmB = new HashSet<>();
        Set<Integer> BmA = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < na; i++) {
            int n = Integer.parseInt(st.nextToken());
            A.add(n);
            AmB.add(n);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nb; i++) {
            int n = Integer.parseInt(st.nextToken());
            AmB.remove(n);
            BmA.add(n);
        }
        for (Integer n : A) {
            BmA.remove(n);
        }
        System.out.print(AmB.size() + BmA.size());
    }
}