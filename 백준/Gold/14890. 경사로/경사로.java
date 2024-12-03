import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            boolean isPossible = true;
            int blockedJ = -1;
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    continue;
                }
                if (map[i][j] - map[i][j + 1] == 1) {
                    for (int k = 2; k <= L; k++) {
                        if (j + k >= N) {
                            isPossible = false;
                            break;
                        }
                        if (map[i][j + 1] != map[i][j + k]) {
                            isPossible = false;
                            break;
                        }
                    }
                    j += L - 1;
                    blockedJ = j + 1;
                    if (blockedJ + 1 < N && map[i][blockedJ] < map[i][blockedJ + 1]) {
                        isPossible = false;
                    }
                    if (!isPossible) {
                        break;
                    }
                } else if (map[i][j] - map[i][j + 1] == -1) {
                    for (int k = 1; k < L; k++) {
                        if (j - k < 0 || blockedJ >= j - k) {
                            isPossible = false;
                            break;
                        }
                        if (map[i][j] != map[i][j - k]) {
                            isPossible = false;
                            break;
                        }
                    }
                    if (!isPossible) {
                        break;
                    }
                } else {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                answer++;
            }
        }

        for (int j = 0; j < N; j++) {
            boolean isPossible = true;
            int blockedI = -1;
            for (int i = 0; i < N - 1; i++) {
                if (map[i][j] == map[i + 1][j]) {
                    continue;
                }
                if (map[i][j] - map[i + 1][j] == 1) {
                    for (int k = 2; k <= L; k++) {
                        if (i + k >= N) {
                            isPossible = false;
                            break;
                        }
                        if (map[i + 1][j] != map[i + k][j]) {
                            isPossible = false;
                            break;
                        }
                    }
                    i += L - 1;
                    blockedI = i + 1;
                    if (blockedI + 1 < N && map[blockedI][j] < map[blockedI + 1][j]) {
                        isPossible = false;
                    }
                    if (!isPossible) {
                        break;
                    }
                } else if (map[i][j] - map[i + 1][j] == -1) {
                    for (int k = 1; k < L; k++) {
                        if (i - k < 0 || blockedI >= i - k) {
                            isPossible = false;
                            break;
                        }
                        if (map[i][j] != map[i - k][j]) {
                            isPossible = false;
                            break;
                        }
                    }
                    if (!isPossible) {
                        break;
                    }
                } else {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                answer++;
            }
        }

        System.out.print(answer);
    }
}
