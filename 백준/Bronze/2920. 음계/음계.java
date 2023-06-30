import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replace(" ", "");
        if (s.equals("12345678")) {
            System.out.println("ascending");
        } else if (s.equals("87654321")) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}