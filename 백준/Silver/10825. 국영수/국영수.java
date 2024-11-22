import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, korean, english, math);
        }
        Arrays.sort(students, (o1, o2) -> {
            if (o1.korean > o2.korean) {
                return -1;
            } else if (o1.korean < o2.korean) {
                return 1;
            }

            if (o1.english < o2.english) {
                return -1;
            } else if (o1.english > o2.english) {
                return 1;
            }

            if (o1.math > o2.math) {
                return -1;
            } else if (o1.math < o2.math) {
                return 1;
            }

            return o1.name.compareTo(o2.name);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(students[i].name).append("\n");
        }
        System.out.print(sb);
    }

    static class Student {

        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
