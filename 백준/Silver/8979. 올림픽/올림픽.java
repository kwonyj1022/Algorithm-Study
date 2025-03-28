import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Country[] countries = new Country[N + 1];
        countries[0] = new Country(0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            countries[n] = new Country(
                    n,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
        Arrays.sort(countries, (o1, o2) -> {
            if (o1.gold != o2.gold) {
                return o2.gold - o1.gold;
            }
            if (o1.silver != o2.silver) {
                return o2.silver - o1.silver;
            }
            return o2.bronze - o1.bronze;
        });

        Country pre = countries[0];
        for (int i = 1; i <= N; i++) {
            if ((pre.gold == countries[i].gold) && (pre.silver == countries[i].silver) && (pre.bronze == countries[i].bronze)) {
                countries[i].rank = pre.rank;
            } else {
                countries[i].rank = i;
            }
            pre = countries[i];
            if (countries[i].n == K) {
                break;
            }
        }
        System.out.print(pre.rank);
    }

    static class Country {
        int n;
        int gold;
        int silver;
        int bronze;
        int rank;

        Country(int n, int gold, int silver, int bronze) {
            this.n = n;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            rank = -1;
        }
    }
}
