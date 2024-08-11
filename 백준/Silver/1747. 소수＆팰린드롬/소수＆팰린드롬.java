import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        boolean[] arr = new boolean[1003002];
        arr[1] = true;
        for (int i = 2; i < 501501; i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = i + i; j < 1003002; j += i) {
                arr[j] = true;
            }
        }
        while(true) {
            if (!arr[N] && isPalindrome(N)) {
                System.out.print(N);
                return;
            }
            N++;
        }
    }

    static boolean isPalindrome(int n) {
        String str = Integer.toString(n);
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}