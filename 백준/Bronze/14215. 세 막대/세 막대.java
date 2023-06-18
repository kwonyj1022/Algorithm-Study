import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] abc = new int[3];
        abc[0] = sc.nextInt();
        abc[1] = sc.nextInt();
        abc[2] = sc.nextInt();
        Arrays.sort(abc);
        if (abc[0] + abc[1] > abc[2]) {
            System.out.println(abc[0] + abc[1] + abc[2]);
        } else {
            System.out.println(2 * (abc[0] + abc[1]) - 1);
        }
    }
}