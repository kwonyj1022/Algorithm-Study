public class Main {
    public static void main(String[] args) {

        boolean[] arr = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            int num = d(i);
            if (num < 10001) {
                arr[num] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }

    static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum = sum + (n % 10);
            n/= 10;
        }
        return sum;

    }
}
