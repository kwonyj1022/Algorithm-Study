import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        
        for (int i = 0; i < N; i++) {
            String tmp1 = list.get(i);
            for (int j = i + 1; j < N; j++) {
                if (tmp1.length() == list.get(j).length()) {
                    String tmp2 = list.get(j) + list.get(j);
                    if (tmp2.contains(tmp1)) {
                        list.remove(j);
                        N--;
                        j--;
                    }
                }
            }
        }
        
        System.out.print(N);
    }
}