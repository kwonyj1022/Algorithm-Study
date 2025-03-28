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
        countries[0] = new Country(0, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = st.nextToken().charAt(0) - '0';
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

        int answer = 0;
        int same = 1;
        Country pre = countries[0];
        for (int i = 1; i <= N; i++) {
            if ((pre.gold == countries[i].gold) && (pre.silver == countries[i].silver) && (pre.bronze == countries[i].bronze)) {
                same++;
            } else {
                answer += same;
                same = 1;
            }
            if (countries[i].n == K) {
                break;
            }
            pre = countries[i];
        }
        System.out.print(answer);
    }

    static class Country {
        int n;
        int gold;
        int silver;
        int bronze;

        Country(int n, int gold, int silver, int bronze) {
            this.n = n;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}
