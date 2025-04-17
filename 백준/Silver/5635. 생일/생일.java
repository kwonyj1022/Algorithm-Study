import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int day = Integer.parseInt(input[1]);
            int month = Integer.parseInt(input[2]);
            int year = Integer.parseInt(input[3]);
            students[i] = new Student(name, year, month, day);
        }
        Arrays.sort(students, (s1, s2) -> {
            if (s1.year != s2.year) {
                return s1.year - s2.year;
            } else if (s1.month != s2.month) {
                return s1.month - s2.month;
            } else {
                return s1.day - s2.day;
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(students[n - 1].name).append("\n").append(students[0].name);
        System.out.print(sb);
    }

    static class Student {
        String name;
        int year;
        int month;
        int day;

        Student(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
}
