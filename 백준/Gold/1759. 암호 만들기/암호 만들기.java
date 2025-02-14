import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int L, C;
    static char[] arr;
    static char[] password;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        arr = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(arr);
        password = new char[L];
        sb = new StringBuilder();

        solve(0, 0);
        System.out.print(sb);
    }

    static void solve(int depth, int start) {
        if (depth == L) {
            int consonant = 0;
            int vowel = 0;
            for (char c : password) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowel++;
                } else {
                    consonant++;
                }
            }
            if (consonant >= 2 && vowel >= 1) {
                sb.append(password).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[depth] = arr[i];
            solve(depth + 1, i + 1);
        }
    }
}
