import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = {5, 3, 4, 4, 4, 4, 4, 4, 4, 4};
        while(true) {
            String N = br.readLine();
            if(N.equals("0")) {
                break;
            }
            int length = 1;
            for(int i = 0; i < N.length(); i++) {
                length += arr[N.charAt(i) - '0'];
            }
            System.out.println(length);
        }
    }

}
