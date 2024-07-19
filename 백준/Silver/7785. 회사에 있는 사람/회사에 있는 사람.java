import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<String> record = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[1].charAt(0) == 'e') {
                record.add(input[0]);
            } else {
                record.remove(input[0]);
            }
        }
        List<String> rl = new ArrayList(record);
        Collections.sort(rl);
        for (int i = rl.size() - 1; i >= 0; i--) {
            bw.write(rl.get(i));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
