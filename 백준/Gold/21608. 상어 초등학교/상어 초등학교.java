import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static List<Student> students;
    static int totalSatisfaction;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[] satisfaction = {0, 1, 10, 100, 1000};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        students = new ArrayList<>();
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Set<Integer> likes = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                likes.add(Integer.parseInt(st.nextToken()));
            }
            students.add(new Student(n, likes));
        }
        for (Student student : students) {
            assign(student);
        }
        for (Student student : students) {
            int nearLikesCnt = getNearLikesCnt(student, student.seat[0], student.seat[1]);
            totalSatisfaction += satisfaction[nearLikesCnt];
        }
        System.out.print(totalSatisfaction);
    }

    static void assign(Student student) {
        int bestRow = 0;
        int bestCol = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int o1NearLikesCnt = getNearLikesCnt(student, o1[0], o1[1]);
            int o2NearLikesCnt = getNearLikesCnt(student, o2[0], o2[1]);
            if (o1NearLikesCnt != o2NearLikesCnt) {
                return o2NearLikesCnt - o1NearLikesCnt;
            }
            int o1NearBlank = getNearBlankCnt(o1[0], o1[1]);
            int o2NearBlank = getNearBlankCnt(o2[0], o2[1]);
            if (o1NearBlank != o2NearBlank) {
                return o2NearBlank - o1NearBlank;
            }
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    pq.offer(new int[]{i, j});
                }
            }
        }

        int[] seat = pq.peek();
        map[seat[0]][seat[1]] = student.number;
        student.seat = seat;
    }

    static int getNearLikesCnt(Student student, int r, int c) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 0) {
                if (student.likes.contains(map[nr][nc])) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static int getNearBlankCnt(int r, int c) {
        int blank = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {
                blank++;
            }
        }

        return blank;
    }

    static class Student {
        int number;
        Set<Integer> likes;
        int[] seat;

        Student(int number, Set<Integer> likes) {
            this.number = number;
            this.likes = likes;
        }
    }
}
