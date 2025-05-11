import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        if (str1.length() >= str2.length()) {
            System.out.print("go");
        } else {
            System.out.print("no");
        }
    }
}
