import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String strA = st.nextToken();
        String strB = st.nextToken();
        int aLen = strA.length();
        int bLen = strB.length();
        int answerLen = Math.max(aLen, bLen) + 1;
        int[] A = new int[answerLen];
        int[] B = new int[answerLen];
        for (int i = aLen - 1, j = 0; i >= 0; i--, j++) {
            A[j] = strA.charAt(i) - '0';
        }
        for (int i = bLen - 1, j = 0; i >= 0; i--, j++) {
            B[j] = strB.charAt(i) - '0';
        }

        for (int i = 0; i < answerLen - 1; i++) {
            int tmp = A[i] + B[i];
            A[i] = tmp % 10;
            A[i + 1] += tmp / 10;
        }

        StringBuffer sb = new StringBuffer();
        if (A[answerLen - 1] != 0) {
            sb.append(A[answerLen - 1]);
        }
        for (int i = answerLen - 2; i >= 0; i--) {
            sb.append(A[i]);
        }
        System.out.println(sb);
    }
}