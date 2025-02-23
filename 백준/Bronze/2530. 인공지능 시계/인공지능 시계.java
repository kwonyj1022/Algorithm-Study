import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        int D = Integer.parseInt(br.readLine());
        int total = A * 3600 + B * 60 + C + D;
        System.out.print(total / 3600 % 24 + " " + total / 60 % 60 + " " + total % 60);
    }
}
