import java.util.Scanner;

public class Main {

    public static int code1 = 0;
    public static int code2 = 0;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        StringBuffer sb = new StringBuffer();
        fib(n);
        sb.append(code1).append(" ").append(n - 2);
        System.out.println(sb);
    }

    public static int fib(int n) {
        if(n == 1 || n == 2){
            code1++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}