import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] student = new int[2][7];
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = st.nextToken().charAt(0) - '0';
            int grade = st.nextToken().charAt(0) - '0';

            student[gender][grade]++;
        }

        for (int i = 0; i < 2; i++) {
            for(int j = 1; j < 7; j++) {
                if (student[i][j] > 0) {
                    if (student[i][j] % M == 0) {
                        answer += (student[i][j] / M);
                    } else {
                        answer += (student[i][j] / M) + 1;
                    }
                }
            }
        }

        System.out.print(answer);
    }
}
