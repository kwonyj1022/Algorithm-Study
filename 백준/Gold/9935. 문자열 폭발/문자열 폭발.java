import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        if (bomb.length == 0) {
            System.out.print(str);
            return;
        }
        int bi = bomb.length - 1;
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < str.length; i++) {
            dq.addLast(str[i]);
            if (dq.peekLast() == bomb[bi]) {
                Stack<Character> popped = new Stack<>();
                for (int j = bi; j >= 0; j--) {
                    if (dq.isEmpty()) {
                        while (!popped.isEmpty()) {
                            dq.addLast(popped.pop());
                        }
                        break;
                    }
                    char pop = dq.pollLast();
                    popped.add(pop);
                    if (pop != bomb[j]) {
                        while (!popped.isEmpty()) {
                            dq.addLast(popped.pop());
                        }
                        break;
                    }
                }
            }
        }
        if (dq.isEmpty()) {
            System.out.print("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        System.out.print(sb);
    }
}
