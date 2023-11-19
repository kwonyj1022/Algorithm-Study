import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N = 0;
    static int G = 0;
    static int K = 0;
    static int KC = 0;
    static int[] S;
    static int[] L;
    static boolean[] O;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new int[N];
        L = new int[N];
        O = new boolean[N];
        int maxSIdx = 0;
        KC = N - K;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            L[i] = Integer.parseInt(st.nextToken());
            if (st.nextToken().equals("0")) {
                O[i] = true;
                KC--;
            }
            if (S[i] > maxSIdx) {
                maxSIdx = i;
            }
        }

        System.out.println(solve(maxSIdx));
    }

    private static long solve(int maxSIdx) {
        int maxDay = (G / S[maxSIdx]) + L[maxSIdx] + 1;
        long min = 0;
        long max = maxDay;
        while (min <= max) {
            long mid = (min + max) / 2;
            if (bugSum(mid) <= G) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return max;
    }

    private static long bugSum(long x) {
        long sum = 0;
        List<Long> discardable = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (O[i]) {
                sum += bug(L[i], S[i], x);
            } else {
                discardable.add(bug(L[i], S[i], x));
            }
        }
        discardable.sort(Comparator.naturalOrder());
        for (int i = 0; i < KC; i++) {
            sum += discardable.get(i);
        }

        return sum;
    }

    private static long bug(int l, int s, long x) {
        return s * Math.max(1, x - l);
    }
}