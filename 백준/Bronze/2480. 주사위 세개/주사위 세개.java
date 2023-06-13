import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int d3 = Integer.parseInt(st.nextToken());

        int price = 0;
        if (d1 == d2 && d2 == d3) {
            price = 10000 + d1 * 1000;
            System.out.println(price);
            return;
        }

        if (d1 == d2) {
            price = 1000 + d1 * 100;
            System.out.println(price);
            return;
        }

        if (d2 == d3) {
            price = 1000 + d2 * 100;
            System.out.println(price);
            return;
        }

        if (d3 == d1) {
            price = 1000 + d3 * 100;
            System.out.println(price);
            return;
        }

        int max = Math.max(d1, Math.max(d2, d3));
        price = max * 100;
        System.out.println(price);
    }
}