import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(new StringBuffer(br.readLine()).reverse().toString());
        int B = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        System.out.println(Math.max(A, B));
    }
}