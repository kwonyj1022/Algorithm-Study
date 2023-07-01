import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        String mul = String.valueOf(A * B * C);
        int size = mul.length();
        
        int[] arr = new int[10];
        for (int i = 0; i < size; i++) {
            arr[mul.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}