import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            strs.add(br.readLine());
        }

        List<String> ds = new ArrayList<>();
        for (int i = 0; i < N; i += K) {
            for (int j = 0; j < M; j += K) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < K; k++) {
                    sb.append(strs.get(i + k).substring(j, j + K));
                }
                ds.add(sb.toString());
            }
        }

        int kk = K * K;
        StringBuilder fs = new StringBuilder();
        for (int i = 0; i < kk; i++) {
            fs.append(findMax(ds, i));
        }
        String finalString = fs.toString();

        System.out.println(cnt);
        printAnswer(finalString, N, M, K);
    }

    private static char findMax(List<String> ds, int idx) {
        int dss = ds.size();
        int[] check = new int[26];
        for (int i = 0; i < dss; i++) {
            check[ds.get(i).charAt(idx) - 'A']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (check[max] < check[i]) {
                max = i;
            }
        }
        cnt += dss - check[max];
        return (char) (max + 'A');
    }

    private static void printAnswer(String finalString, int N, int M, int K) {
        String[] ans = new String[K];
        int len = finalString.length();
        int div = len / K;
        for (int i = 0; i < div; i++) {
            ans[i] = finalString.substring(K * i , K * (i + 1));
        }
        StringBuilder sb = new StringBuilder();
        int cnt1 = N / K;
        int cnt2 = M / K;
        for (int i = 0; i < cnt1; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < cnt2; k++) {
                    sb.append(ans[j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}