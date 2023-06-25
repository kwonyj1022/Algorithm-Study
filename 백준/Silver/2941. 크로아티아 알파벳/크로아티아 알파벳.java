import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        for (String s : arr) {
            word = word.replace(s, "0");
        }
        System.out.println(word.length());
    }
}