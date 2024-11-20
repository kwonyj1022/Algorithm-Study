import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            list.add(S.substring(i));
        }
        list.sort(String::compareTo);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}