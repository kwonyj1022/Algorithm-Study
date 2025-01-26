import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] input = br.readLine().toCharArray();
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();
            for (Character c : input) {
                if (c == '<') {
                    if (!left.isEmpty()) {
                        right.addFirst(left.pollLast());
                    }
                } else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.addLast(right.pollFirst());
                    }
                } else if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                } else {
                    left.addLast(c);
                }
            }

            while (!left.isEmpty()) {
                sb.append(left.pollFirst());
            }
            while (!right.isEmpty()) {
                sb.append(right.pollFirst());
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
