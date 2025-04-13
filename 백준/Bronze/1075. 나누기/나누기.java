import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        N /= 100;
        N *= 100;
        int answer = 0;
        while (N % F != 0) {
            N++;
            answer++;
        }
        StringBuilder sb = new StringBuilder();
        if (answer < 10) {
            sb.append("0");
        }
        sb.append(answer);
        System.out.print(sb);
    }
}
