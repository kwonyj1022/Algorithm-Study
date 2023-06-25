import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toUpperCase();
        int length = word.length();
        int[] counts = new int[26];
        for (int i = 0; i < length; i++) {
            counts[word.charAt(i) - 'A']++;
        }
        int maxIdx = 0;
        for (int i = 0; i < 25; i++) {
            if (counts[maxIdx] < counts[i + 1]) {
                maxIdx = i + 1;
            }
        }
        int maxCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] == counts[maxIdx]) {
                maxCnt++;
            }
            if (maxCnt == 2) {
                System.out.println("?");
                return;
            }
        }
        System.out.println((char) (maxIdx + 'A'));
    }
}