import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, chickenCnt;
    static List<Home> homes;
    static int answer;
    static int[] survive;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        homes = new ArrayList<>();
        List<int[]> chickens = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    homes.add(new Home(i, j));
                } else if (value == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        chickenCnt = chickens.size();
        for (Home home: homes) {
            home.calculate(chickens);
        }
        answer = Integer.MAX_VALUE;
        survive = new int[M];
        solve(0, 0);
        System.out.print(answer);
    }

    static void solve(int start, int depth) {
        if (depth == M) {
            int sum = 0;
            for (Home home: homes) {
                int minDistance = home.distances.get(survive[0]);
                for (int i = 1; i < M; i++) {
                    minDistance = Math.min(minDistance, home.distances.get(survive[i]));
                }
                sum += minDistance;
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = start; i < chickenCnt; i++) {
            survive[depth] = i;
            solve(i + 1, depth + 1);
        }
    }

    static class Home {
        int r, c;
        List<Integer> distances;

        Home(int r, int c) {
            this.r = r;
            this.c = c;
            this.distances = new ArrayList<>();
        }

        void calculate(List<int[]> chickens) {
            for (int[] chicken: chickens) {
                distances.add(Math.abs(r - chicken[0]) + Math.abs(c - chicken[1]));
            }
        }
    }
}
