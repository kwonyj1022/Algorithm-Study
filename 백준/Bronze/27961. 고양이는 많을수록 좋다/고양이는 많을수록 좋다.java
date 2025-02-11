import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        int cnt = 0;
        while (N > 3) {
            cnt++;
            N = N / 2 + N % 2;
        }

        System.out.println(cnt + N);
    }
}

