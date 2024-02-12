import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < P; i++) {
            char w = str.charAt(i);
            if (w == 'A') {
                a--;
            } else if (w == 'C') {
                c--;
            } else if (w == 'G') {
                g--;
            } else {
                t--;
            }
        }
        int answer = 0;
        if (!(a > 0 || c > 0 || g > 0 || t > 0)) {
            answer++;
        }

        int l = 0;
        int r = P;
        while (r < S) {
            char w = str.charAt(l);
            if (w == 'A') {
                a++;
            } else if (w == 'C') {
                c++;
            } else if (w == 'G') {
                g++;
            } else {
                t++;
            }

            w = str.charAt(r);
            if (w == 'A') {
                a--;
            } else if (w == 'C') {
                c--;
            } else if (w == 'G') {
                g--;
            } else {
                t--;
            }

            if (!(a > 0 || c > 0 || g > 0 || t > 0)) {
                answer++;
            }
            l++;
            r++;
        }

        System.out.println(answer);
        br.close();
    }
}