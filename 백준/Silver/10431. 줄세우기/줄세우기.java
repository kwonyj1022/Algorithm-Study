import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[20];
        for (int i = 1; i <= P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");
            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(solve()).append("\n");
        }
        System.out.print(sb);
    }

    static int solve() {
        int cnt = 0;
        Student head = new Student(arr[0]);
        for (int i = 1; i < 20; i++) {
            int smallCnt = 0;
            Student pre = null;
            Student next = head;
            while (next != null) {
                if (next.height < arr[i]) {
                    pre = next;
                    next = next.next;
                    smallCnt++;
                } else {
                    break;
                }
            }
            if (pre == null) {
                Student tmp = head;
                head = new Student(arr[i]);
                head.next = tmp;
            } else {
                pre.next = new Student(arr[i]);
                pre.next.next = next;
            }
            cnt += i - smallCnt;
        }
        return cnt;
    }

    static class Student {
        int height;
        Student next;

        public Student(int height) {
            this.height = height;
        }
    }
}
