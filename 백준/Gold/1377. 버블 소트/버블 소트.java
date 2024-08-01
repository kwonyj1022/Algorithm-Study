import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Data[] arr = new Data[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Data(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr, (o1, o2) -> o1.value - o2.value);
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, arr[i].index - i);
        }

        System.out.print(max + 1);
    }

    static class Data {
        int value;
        int index;

        public Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
