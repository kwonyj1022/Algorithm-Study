import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int sLength = S.length();
        int[] sum = new int[sLength + 1];
        sum[0] = 0;
        for (int i = 0; i < sLength; i++) {
            sum[i + 1] = sum[i] + S.charAt(i);
        }

        int max = sLength / 2;
        int answer = 0;
        int tmp = 1;
        int s1 = 1;
        int s2 = 2;
        while (tmp <= max) {
            if (sum[s2 - 1] - sum[s1 - 1] == sum[s2 + tmp - 1] - sum[s2 - 1]) {
                answer = tmp * 2;
                tmp++;
                s1 = 1;
                s2 = tmp + 1;
            } else {
                if (s2 + tmp - 1 == sLength) {
                    tmp++;
                    s1 = 1;
                    s2 = tmp + 1;
                } else {
                    s1++;
                    s2++;
                }
            }
        }


        System.out.println(answer);
    }
}